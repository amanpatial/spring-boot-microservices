package com.microservice.education.userservice;

import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.resource.UserResource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserResourceTests {

    @LocalServerPort
    private int port;

    @Autowired
    private UserResource userResource;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenUserResource_whenContextLoad_thenNotNull() throws Exception {
        assertThat(userResource).isNotNull();
    }

    @Test
    public void givenUserResourceUrl_whenSendGetForRequestEntity_thenStatusOk() throws URISyntaxException {

        final String url = "http://localhost:" + port + "/users";
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(url, Object[].class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void givenUserService_whenCallHeadForHeaders_thenReceiveAllHeadersForThatResource() {

        final String url = "http://localhost:" + port + "/users";
        final HttpHeaders httpHeaders = restTemplate.headForHeaders(url);
        assertTrue(httpHeaders.getContentType()
                .includes(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenUserService_whenPostForObject_thenCreatedObjectIsReturned() {

        final String url = "http://localhost:" + port + "/users";
        HttpEntity<User> request = new HttpEntity<>(new User("testUser", "test@email.com"));
        User userResult = restTemplate.postForObject(url, request, User.class);
        assertThat(userResult).isNull();
    }
}

package com.microservice.education.userservice;

import static org.assertj.core.api.Assertions.assertThat;

import com.microservice.education.userservice.resource.AddressResource;
import com.microservice.education.userservice.resource.UserResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private UserResource userResource;

    @Autowired
    private AddressResource addressResource;


    @Test
    public void contexLoads() throws Exception {
        assertThat(userResource).isNotNull();
        assertThat(addressResource).isNotNull();
    }
}

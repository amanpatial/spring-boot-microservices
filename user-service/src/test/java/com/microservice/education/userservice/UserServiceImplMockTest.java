package com.microservice.education.userservice;

import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.UserRepository;
import com.microservice.education.userservice.service.UserService;
import com.microservice.education.userservice.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplMockTest {

    @Mock
    private static UserRepository userRepository;

    @InjectMocks
    private static UserService userService = new UserServiceImpl();

    @Test
    public void testGetAllUsers_usingMock() {

        List<User> testUsers = Arrays.asList(
                new User("aman", "aman.patial@gmail.com"),
                new User("raman", "raman.patial@gmail.com"));

        when(userRepository.findAll()).thenReturn(testUsers);

        List<User> users = userService.getAllUsers();

        assertThat(2).isEqualTo(users.size());
    }


    @Test
    public void testFindUserByName_usingMock() {

        List<User> testUsers = Arrays.asList(
                new User("aman", "aman.patial@gmail.com"),
                new User("raman", "raman.patial@gmail.com"));

        when(userRepository.findByName("aman")).thenReturn((testUsers));

        List<User> users = userService.findByName("Aman");

        assertThat(0).isEqualTo(users.size());
    }

}

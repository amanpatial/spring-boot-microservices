package com.microservice.education.userservice;

import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.UserRepository;
import com.microservice.education.userservice.service.UserService;
import com.microservice.education.userservice.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplMockSpyTest {


    @Spy  //to spy on a real object
    UserService userService = new UserServiceImpl();

    @Test
    public void testGetUserSpyWithStub() throws Exception {

        Long id = Long.valueOf(3);

        //Stub user
        User stubUser = new User("Pawan", "pawan.patial@gmail.com");

        doReturn(stubUser).when(userService).getUser(id);

        User spyUser = userService.getUser(id);

        verify(userService, times(1)).getUser(id);
        assertEquals("Pawan", spyUser.getName());
        assertEquals("pawan.patial@gmail.com", spyUser.getEmail());
    }

}

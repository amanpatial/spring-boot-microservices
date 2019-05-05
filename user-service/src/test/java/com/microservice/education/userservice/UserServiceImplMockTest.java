package com.microservice.education.userservice;

import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.UserRepository;
import com.microservice.education.userservice.service.UserService;
import com.microservice.education.userservice.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplMockTest {

    @Mock
    private static UserRepository userRepository;

    @InjectMocks
    private static UserService userService = new UserServiceImpl();

    @BeforeEach
    public void setUp(){

    }

    @Test
    @DisplayName("Get All Users")
    public void testGetAllUsers_usingMock() throws Exception {
        //Arrange
        //Stub users
        List<User> testUsers = Arrays.asList(
                new User("aman", "aman.patial@gmail.com"),
                new User("raman", "raman.patial@gmail.com"));
        when(userRepository.findAll()).thenReturn(testUsers);

        //act
        List<User> users = userService.getAllUsers();

        //assert
        assertThat(2).isEqualTo(users.size());
    }


    @Test
    @DisplayName("Add a User")
    public void testAddUser_usingMock() throws Exception {
        //Arrange
        User testUser = new User("aman", "aman.patial@gmail.com");
        when(userRepository.save(testUser)).thenReturn(testUser);

        //act
        User user = userService.addUser(testUser);

        //assert
        assertThat(testUser).isEqualTo(user);
    }

    @Test
    @DisplayName("Update a User")
    public void testUpdateUser_usingMock() throws Exception {
        //Arrange
        User testUser = new User("Paman", "pawan.patial@gmail.com");
        Long id = Long.valueOf(3);
        when(userRepository.save(testUser)).thenReturn(testUser);

        //act
        User user = userService.updateUser(testUser,  id);

        //assert
        assertThat(testUser).isEqualTo(user);
    }

    @Test
    @DisplayName("Delete a User")
    public void testDeleteUser_usingMock() throws Exception {
        //Arrange
        Long id = Long.valueOf(3);
        doNothing().when(userRepository).deleteById(id);

        //act
        userService.deleteUser(id);

        //assert
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindUserByName_usingMock() throws Exception {
        //Arrange
        //Stub user
        List<User> testUser = Arrays.asList(
                new User("aman", "aman.patial@gmail.com"));
        when(userRepository.findByName("aman")).thenReturn((testUser));

        //act
        List<User> users = userService.findByName("aman");

        //assert
        assertThat(1).isEqualTo(users.size());
    }


}

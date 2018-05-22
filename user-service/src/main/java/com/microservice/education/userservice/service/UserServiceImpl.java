package com.microservice.education.userservice.service;
import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("1", "Aman", "aman.patial@gmail.com"),
            new User("2", "Raman", "raman.patial@gmail.com")
    ));

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

   public void addUser(User user) {
        userRepository.save(user);
       //users.add(user);
   }

}

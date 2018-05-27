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

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public User getUser(Long id){ return userRepository.getOne(id); }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public void updateUser(User user, Long id){
        userRepository.save(user);
    }
    public void addUser(User user) { userRepository.save(user); }

}

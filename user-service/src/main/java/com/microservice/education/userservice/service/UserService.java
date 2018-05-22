package com.microservice.education.userservice.service;
import com.microservice.education.userservice.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void addUser(User user);
}

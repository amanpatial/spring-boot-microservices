package com.microservice.education.userservice.service;
import com.microservice.education.userservice.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(Long id);
    public void deleteUser(Long id);
    public void updateUser(User user, Long id);
    public void addUser(User user);
    public List<User> findByName(String name);
}

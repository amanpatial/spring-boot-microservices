package com.microservice.education.userservice.service;
import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
    public User updateUser(User user, Long id){
        return userRepository.save(user);
    }
    public User addUser(User user) { return userRepository.save(user); }
    public List<User> findByName(String name) { return userRepository.findByName(name);}
}

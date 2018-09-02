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
    public List<User> findByName(String text) {

       // log.info("Find By Name :" + text);
        System.out.print("Find By Name :" + text);
        List<User> filterUsersByName = new ArrayList<>();
        List<User> users = getAllUsers();
        for( User user : users) {
            System.out.println(user.getName().toString());
            System.out.println(user.getName().contains(text));
            System.out.println( (user.getName().toString() == text));
              if (user.getName().contains(text)){
                  filterUsersByName.add(user);
                  System.out.print(user.getName());
              }
        }
        System.out.print(filterUsersByName);
        return filterUsersByName;
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

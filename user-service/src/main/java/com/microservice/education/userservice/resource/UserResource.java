package com.microservice.education.userservice.resource;

import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.UserRepository;
import com.microservice.education.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoint to be used by other micro-services
 * @author aman
 *
 */
@EnableDiscoveryClient
@RestController
public class UserResource {
    @Autowired
    private UserService userService;

   @RequestMapping("/hello")
    public String getName(){
       return "Hello";
   }
    @RequestMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(method = RequestMethod.POST, value ="/users")
    public void addUser(@RequestBody User user){
       userService.addUser(user);
    }

}

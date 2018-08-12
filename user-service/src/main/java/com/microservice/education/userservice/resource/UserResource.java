package com.microservice.education.userservice.resource;

import com.microservice.education.userservice.model.User;

import com.microservice.education.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoint to be used by other micro-services
 * @author aman
 *
 */

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String getName(){
       return "Hello";
   }

    @CrossOrigin(origins = "*")
    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value ="/users")
    public void addUser(@RequestBody User user){
       userService.addUser(user);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT, value ="/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(user, id);
    };

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE, value= "/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}

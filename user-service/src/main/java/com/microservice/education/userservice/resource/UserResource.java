package com.microservice.education.userservice.resource;

import com.microservice.education.userservice.model.Address;
import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getUsers() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List<User>>(userService.getAllUsers(), responseHeaders, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value ="/users")
    public void addUser(@RequestBody User user){
        //userService.addUser(user);
        addUserAndAddress();
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

    @CrossOrigin(origins = "*")
    public List<User> findByName(@RequestParam(value="name") String name){
        return userService.findByName(name);
    }

    //Demonstrate the capabilities to handle the one to many and many to one
    public void addUserAndAddress(){
        //Create User
        User amanUser = new User("Aman", "aman.patial@gmail.com");

        // Create first address
        Address add1 = new Address("Amritsar");
        add1.setUser(amanUser);

        // Create second address
        Address add2 = new Address("Bangalore");
        add2.setUser(amanUser);

        // Add both addresses in User
        amanUser.getAddresses().add(add1);
        amanUser.getAddresses().add(add2);

        // Save User and Addresses via the User entity
        userService.addUser(amanUser);
    }

}

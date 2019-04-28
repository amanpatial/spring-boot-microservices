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
 *
 * @author aman
 */

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String getName() {
        return "Hello";
    }

    // Get All Users
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List<User>>(userService.getAllUsers(), responseHeaders, HttpStatus.OK);
    }

    // Get Single User
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    // Add User
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //addUserAndAddress();
    }

    // Update User
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
    }

    ;

    // Delete User
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // Get Users by name
    @CrossOrigin(origins = "*")
    @RequestMapping("/filter")
    public List<User> findByName(@RequestParam(value = "name") String name) {
        return userService.findByName(name);
    }

    //Demonstrate the capabilities to handle the one to many and many to one
    public void addUserAndAddress() {
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

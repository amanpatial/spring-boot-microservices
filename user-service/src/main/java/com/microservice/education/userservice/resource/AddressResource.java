package com.microservice.education.userservice.resource;

import com.microservice.education.userservice.model.Address;
import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.AddressRepository;
import com.microservice.education.userservice.repositories.UserRepository;
import com.microservice.education.userservice.service.AddressService;
import com.microservice.education.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressResource {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @RequestMapping("/address")
    public ResponseEntity<List<Address>> getAddress() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List<Address>>(addressService.getAllAddress(), responseHeaders, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value ="/address")
    public ResponseEntity<Void> addAddress(Address address){
        addressService.addAddress(address);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/users/{userId}/addresses")
    public ResponseEntity<Void> createAddress(@PathVariable (value = "userId") Long userId, @Valid @RequestBody Address address) {
        addressService.addAddress(userId, address);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

package com.microservice.education.userservice.service;
import com.microservice.education.userservice.model.Address;
import com.microservice.education.userservice.model.User;
import com.microservice.education.userservice.repositories.AddressRepository;
import com.microservice.education.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Address> getAllAddress() {
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }
    public void addAddress(Address address) { addressRepository.save(address); }

    public void addAddress(Long userId, Address address) {
        User user = userRepository.getOne(userId);
        if (user != null){
            address.setUser(user);
            addressRepository.save(address);
        }
    }
}

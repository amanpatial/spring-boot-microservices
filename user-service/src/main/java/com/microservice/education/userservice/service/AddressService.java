package com.microservice.education.userservice.service;

import com.microservice.education.userservice.model.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAllAddress();
    public void addAddress(Address address);
    public void addAddress(Long userId, Address address);
}

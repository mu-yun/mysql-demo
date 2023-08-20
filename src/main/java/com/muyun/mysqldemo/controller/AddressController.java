package com.muyun.mysqldemo.controller;

import com.muyun.mysqldemo.entity.Address;
import com.muyun.mysqldemo.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

}

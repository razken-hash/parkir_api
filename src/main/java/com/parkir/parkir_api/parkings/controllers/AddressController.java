package com.parkir.parkir_api.addresss.controllers;

import com.parkir.parkir_api.ParkirConsts;
import com.parkir.parkir_api.parkings.entities.Address;
import com.parkir.parkir_api.parkings.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/addresss/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddresss() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable("addressId") Integer addressId) {
        return addressService.getAddressById(addressId).get();
    }

    @PostMapping("/create")
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

}

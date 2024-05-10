package com.parkir.parkir_api.parkings.services;

import com.parkir.parkir_api.parkings.entities.Address;
import com.parkir.parkir_api.parkings.entities.Parking;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.parkings.repositories.AddressRepository;
import com.parkir.parkir_api.parkings.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Integer addressId) {
        return addressRepository.findById(addressId);
    }

    public Address createAddress(Address address) {
        Optional<Address> optionalParking = addressRepository.findAddressByStreetAndCity(address.getStreet(), address.getCity());
        if (optionalParking.isPresent()) {
            throw new IllegalStateException("Address already exists");
        }
        return addressRepository.save(address);
    }
}

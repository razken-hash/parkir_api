package com.parkir.parkir_api.parkings.repositories;

import com.parkir.parkir_api.parkings.entities.Address;
import com.parkir.parkir_api.parkings.entities.Floor;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findAddressByLongitudeAndLatitude(Double longitude, Double latitude);
    Optional<Address> findAddressByStreetAndCity(String street, String city);
}

package com.parkir.parkir_api.parkings.repositories;

import com.parkir.parkir_api.parkings.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    public Optional<Parking> findParkingByName(String email);
}

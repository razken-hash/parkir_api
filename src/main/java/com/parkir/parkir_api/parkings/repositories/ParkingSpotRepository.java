package com.parkir.parkir_api.parkings.repositories;

import com.parkir.parkir_api.parkings.entities.Floor;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
    public Optional<ParkingSpot> findParkingParkingSpotByFloorAndNumber(Floor floor, Integer number);
}

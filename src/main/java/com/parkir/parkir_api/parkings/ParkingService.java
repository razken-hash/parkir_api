package com.parkir.parkir_api.parkings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    public void createParking(Parking parking) {
        Optional<Parking> optionalParking = parkingRepository.findParkingByName(parking.getName());
        if (optionalParking.isPresent()) {
            throw new IllegalStateException("Parking already exists");
        }
        parkingRepository.save(parking);
    }
}

package com.parkir.parkir_api.parkings.services;

import com.parkir.parkir_api.parkings.entities.Parking;
import com.parkir.parkir_api.parkings.repositories.ParkingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Parking createParking(Parking parking) {
        Optional<Parking> optionalParking = parkingRepository.findParkingByName(parking.getName());
        if (optionalParking.isPresent()) {
            throw new IllegalStateException("Parking already exists");
        }
        return parkingRepository.save(parking);
    }

    public void deleteParking(Integer parkingId) {
        boolean exists = parkingRepository.existsById(parkingId);
        if (!exists) {
            throw new IllegalStateException("Parking not exist");
        }
        parkingRepository.deleteById(parkingId);
    }

    @Transactional
    public Parking updateParking(Integer parkingId, String name, String description, String image, /* String city, String address, Double longitude, Double latitude,*/ LocalTime openingTime, LocalTime closingTime, Double pricePerHour) throws IllegalStateException {
        Parking parking = parkingRepository.findById(parkingId).orElseThrow(() -> new IllegalStateException("Parking not exist"));
        if (name != null) {
            parking.setName(name);
        }
        if (description != null) {
            parking.setDescription(description);
        }
        if (image != null) {
            parking.setImage(image);
        }
        if (openingTime != null) {
            parking.setOpeningTime(openingTime);
        }
        if (closingTime != null) {
            parking.setClosingTime(closingTime);
        }
        if (pricePerHour != null) {
            parking.setPricePerHour(pricePerHour);
        }
        return parking;
    }

    public Optional<Parking> getParkingById(Integer parkingId) {
        return parkingRepository.findById(parkingId);
    }
}

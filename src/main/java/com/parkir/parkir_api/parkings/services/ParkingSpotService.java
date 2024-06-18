package com.parkir.parkir_api.parkings.services;

import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.parkings.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;

    @Autowired
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }
    public Optional< ParkingSpot> getParkingSpotById(Integer parkingSpotId) {
        return parkingSpotRepository.findById(parkingSpotId);
    }

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        Optional<ParkingSpot> floorOptional = parkingSpotRepository.findParkingParkingSpotByFloorAndNumber(parkingSpot.getFloor(), parkingSpot.getNumber());
        if (floorOptional.isPresent()) {
            throw new IllegalStateException("ParkingSpot already exists");
        }
        return parkingSpotRepository.save(parkingSpot);
    }

    @Transactional
    public ParkingSpot updateParkingSpot(Integer parkingSpotId, Integer number) throws IllegalStateException {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(parkingSpotId).orElseThrow(() -> new IllegalStateException("ParkingSpot not exist"));
        if (number != null) {
            parkingSpot.setNumber(number);
        }
        return parkingSpot;
    }

    public void deleteParkingSpot(Integer parkingSpotId) {
        boolean exists = parkingSpotRepository.existsById(parkingSpotId);
        if (!exists) {
            throw new IllegalStateException("ParkingSpot not exist");
        }
        parkingSpotRepository.deleteById(parkingSpotId);
    }
}

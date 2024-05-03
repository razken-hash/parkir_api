package com.parkir.parkir_api.parkings.services;

import com.parkir.parkir_api.parkings.models.Floor;
import com.parkir.parkir_api.parkings.models.Parking;
import com.parkir.parkir_api.parkings.repositories.FloorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorService {

    private final FloorRepository floorRepository;

    @Autowired
    public FloorService(FloorRepository parkingRepository) {
        this.floorRepository = parkingRepository;
    }

    public List<Floor> getAllFloors() {
        return floorRepository.findAll();
    }

    public void createFloor(Floor floor) {
        Optional<Floor> floorOptional = floorRepository.findFloorByParkingAndNumber(floor.getParking(), floor.getNumber());
        if (floorOptional.isPresent()) {
            throw new IllegalStateException("Floor already exists");
        }
        Floor newFloor = floor;
        floor.getPlaces().forEach(
                place -> {
                    place.setFloor(newFloor);
                }
        );
        floorRepository.save(floor);
    }

    public void deleteFloor(Integer floorId) {
        boolean exists = floorRepository.existsById(floorId);
        if (!exists) {
            throw new IllegalStateException("Floor not exist");
        }
        floorRepository.deleteById(floorId);
    }

    @Transactional
    public void updateParking(Integer floorId, String name, String description) throws IllegalStateException {
        Floor floor = floorRepository.findById(floorId).orElseThrow(() -> new IllegalStateException("Floor not exist"));
        if (name != null) {
            floor.setName(name);
        }
        if (description != null) {
            floor.setDescription(description);
        }
    }
}

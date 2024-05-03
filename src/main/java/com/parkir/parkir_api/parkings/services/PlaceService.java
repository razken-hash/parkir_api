package com.parkir.parkir_api.parkings.services;

import com.parkir.parkir_api.parkings.models.Place;
import com.parkir.parkir_api.parkings.repositories.PlaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public void createPlace(Place place) {
        Optional<Place> floorOptional = placeRepository.findPlaceByFloorAndNumber(place.getFloor(), place.getNumber());
        if (floorOptional.isPresent()) {
            throw new IllegalStateException("Place already exists");
        }
        placeRepository.save(place);
    }

    public void deletePlace(Integer placeId) {
        boolean exists = placeRepository.existsById(placeId);
        if (!exists) {
            throw new IllegalStateException("Place not exist");
        }
        placeRepository.deleteById(placeId);
    }

    @Transactional
    public void updatePlace(Integer placeId, Integer number) throws IllegalStateException {
        Place place = placeRepository.findById(placeId).orElseThrow(() -> new IllegalStateException("Place not exist"));
        if (number != null) {
            place.setNumber(number);
        }
    }
}

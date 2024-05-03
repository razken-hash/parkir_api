package com.parkir.parkir_api.parkings.repositories;

import com.parkir.parkir_api.parkings.models.Floor;
import com.parkir.parkir_api.parkings.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    public Optional<Place> findPlaceByFloorAndNumber(Floor floor, Integer number);
}

package com.parkir.parkir_api.parkings.repositories;

import com.parkir.parkir_api.parkings.entities.Floor;
import com.parkir.parkir_api.parkings.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {
    public  Optional<Floor> findFloorByParkingAndNumber(Parking parking, Integer floorId);
}

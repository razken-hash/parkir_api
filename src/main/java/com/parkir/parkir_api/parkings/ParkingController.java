package com.parkir.parkir_api.parkings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/parkings")
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public List<Parking> getAllParkings() {
        return parkingService.getAllParkings();
    }


    @PostMapping("/create")
    public void createParking(@RequestBody Parking parking) {
        parkingService.createParking(parking);
    }

    @DeleteMapping(path = "/delete/{parkingId}")
    public void deleteParking(@PathVariable("parkingId") Integer parkingId) {
        parkingService.deleteParking(parkingId);
    }
}

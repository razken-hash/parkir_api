package com.parkir.parkir_api.parkings.controllers;

import com.parkir.parkir_api.ParkirConsts;
import com.parkir.parkir_api.parkings.entities.Parking;
import com.parkir.parkir_api.parkings.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/parkings")
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

    @GetMapping("/{parkingId}")
    public Parking getParkingById(@PathVariable("parkingId") Integer parkingId) {
        return parkingService.getParkingById(parkingId);
    }

    @PostMapping("/create")
    public Parking createParking(@RequestBody Parking parking) {
        return parkingService.createParking(parking);
    }

    @PutMapping("/update/{parkingId}")
    public Parking updateParking(@PathVariable("parkingId") Integer parkingId,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "description", required = false) String description,
                                 @RequestParam(value = "image", required = false) String image,
                                 @RequestParam(value = "openingTime", required = false) String openingTime,
                                 @RequestParam(value = "openingTime", required = false) String closingTime,
                                 @RequestParam(value = "pricePerHour", required = false) Double pricePerHour
    ) {
        LocalTime oTime = LocalTime.parse(openingTime);
        LocalTime cTime = LocalTime.parse(closingTime);
        return parkingService.updateParking(parkingId, name, description, image, oTime, cTime, pricePerHour);
    }

    @DeleteMapping(path = "/delete/{parkingId}")
    public void deleteParking(@PathVariable("parkingId") Integer parkingId) {
        parkingService.deleteParking(parkingId);
    }
}

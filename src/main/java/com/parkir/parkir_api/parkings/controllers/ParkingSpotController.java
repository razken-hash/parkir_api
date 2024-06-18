package com.parkir.parkir_api.parkings.controllers;

import com.parkir.parkir_api.ParkirConsts;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.parkings.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/parkings/floors/parkingspots")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    @Autowired
    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotService.getAllParkingSpots();
    }

    @GetMapping("/{parkingSpotId}")
    public ParkingSpot getParkingSpotById(@PathVariable("parkingSpotId") Integer parkingSpotId) {
        return parkingSpotService.getParkingSpotById(parkingSpotId).orElseThrow(() -> new IllegalStateException("ParkingSpot Not Exists"));
    }

    @PostMapping("/create")
    public ParkingSpot createParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        return parkingSpotService.createParkingSpot(parkingSpot);
    }

    @PutMapping("/update/{parkingSpotId}")
    public ParkingSpot updateParkingSpot(@PathVariable("parkingSpotId") Integer parkingSpotId,
                                         @RequestParam(value = "number", required = false) Integer number
    ) {
        return parkingSpotService.updateParkingSpot(parkingSpotId, number);
    }

    @DeleteMapping(path = "/delete/{parkingSpotId}")
    public void deleteParkingSpot(@PathVariable("parkingSpotId") Integer parkingSpotId) {
        parkingSpotService.deleteParkingSpot(parkingSpotId);
    }
}

package com.parkir.parkir_api.parkings.controllers;

import com.parkir.parkir_api.ParkirConsts;
import com.parkir.parkir_api.parkings.services.FloorService;
import com.parkir.parkir_api.parkings.entities.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/parkings/floors")
public class FloorController {

    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping
    public List<Floor> getAllFloors() {
        return floorService.getAllFloors();
    }

    @PostMapping("/create")
    public void createFloor(@RequestBody Floor floor) {
        floorService.createFloor(floor);
    }

    @PutMapping("/update/{floorId}")
    public String updateFloor(@PathVariable("floorId") Integer floorId,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "description", required = false) String description
    ) {
        floorService.updateParking(floorId, name, description);
        return "Welcome To PUT";
    }

    @DeleteMapping(path = "/delete/{floorId}")
    public void deleteFloor(@PathVariable("floorId") Integer floorId) {
        floorService.deleteFloor(floorId);
    }
}

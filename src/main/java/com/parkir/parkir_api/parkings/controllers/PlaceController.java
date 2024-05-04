package com.parkir.parkir_api.parkings.controllers;

import com.parkir.parkir_api.parkings.entities.Place;
import com.parkir.parkir_api.parkings.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parkings/floors/places")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @PostMapping("/create")
    public void createPlace(@RequestBody Place place) {
        placeService.createPlace(place);
    }

    @PutMapping("/update/{placeId}")
    public void updatePlace(@PathVariable("placeId") Integer placeId,
                              @RequestParam(value = "number", required = false) Integer number
    ) {
        placeService.updatePlace(placeId, number);
    }

    @DeleteMapping(path = "/delete/{placeId}")
    public void deletePlace(@PathVariable("placeId") Integer placeId) {
        placeService.deletePlace(placeId);
    }
}

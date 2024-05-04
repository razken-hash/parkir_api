package com.parkir.parkir_api.parkings.config;

import com.parkir.parkir_api.parkings.entities.Floor;
import com.parkir.parkir_api.parkings.entities.Parking;
//import com.parkir.parkir_api.parkings.models.Floor;
import com.parkir.parkir_api.parkings.entities.Place;
import com.parkir.parkir_api.parkings.services.ParkingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.List;

@Configuration
public class ParkingConfig {

    List<Parking> parkings = List.of(
            new Parking(13, "Central Parking", "Conveniently located in the city center.",
                    "image1.jpg", "123 Main Street", "New York",
                    40.7128, -74.0060, LocalTime.of(8, 0), LocalTime.of(20, 0), 10D,
                    List.of(
                            new Floor(1, "FloorA", "FloorA Description"),
                            new Floor(2, "FloorB", "FloorB Description"),
                            new Floor(3, "FloorC", "FloorC Description")
                    )
            ),

            new Parking("Green Park", "Eco-friendly with electric vehicle charging stations.",
                    "image2.jpg", "456 Elm Street", "Los Angeles",
                    34.0522, -118.2437, LocalTime.of(9, 0), LocalTime.of(18, 0), 8D
                    , List.of()
            ),

            new Parking("Lakeview Parking", "Scenic views of the nearby lake.",
                    "image3.jpg", "789 Lakeview Avenue", "Chicago",
                    41.8781, -87.6298, LocalTime.of(7, 30), LocalTime.of(22, 0), 12D
                    , List.of()),

            new Parking("Downtown Garage", "Bustling downtown area convenience.",
                    "image4.jpg", "101 Broadway", "San Francisco",
                    37.7749, -122.4194, LocalTime.of(6, 0), LocalTime.of(23, 0), 15D
                    , List.of()),

            new Parking("Suburban Park", "Spacious suburban lot in a quiet neighborhood.",
                    "image5.jpg", "222 Oak Street", "Houston",
                    29.7604, -95.3698, LocalTime.of(7, 0), LocalTime.of(19, 30), 7D
                    , List.of())
    );

    @Bean
    CommandLineRunner commandLineRunner(ParkingService service) {

        parkings.forEach(
                parking -> {
                    parking.getFloors().forEach(
                            floor -> {
                                Floor newFloor = floor;
                                List<Place> places = List.of(
                                        new Place(1, newFloor),
                                        new Place(2, newFloor),
                                        new Place(3, newFloor)
                                );
                                floor.setPlaces(places);
                            }
                    );
                }
        );

        return args -> {
            parkings.forEach(
                    parking -> {
                        service.createParking(parking);
                    }
            );
        };
    }
}

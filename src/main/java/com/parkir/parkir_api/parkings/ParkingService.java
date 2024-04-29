package com.parkir.parkir_api.parkings;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
@Service
public class ParkingService {
    public List<Parking> getAllParkings() {
        return List.of(
                new Parking(1, "Central Parking", "Conveniently located in the city center.",
                       "image1.jpg", "123 Main Street", "New York",
                        40.7128, -74.0060, LocalTime.of(8, 0), LocalTime.of(20, 0), 10),

                new Parking(2, "Green Park", "Eco-friendly with electric vehicle charging stations.",
                        "image2.jpg", "456 Elm Street", "Los Angeles",
                        34.0522, -118.2437, LocalTime.of(9, 0), LocalTime.of(18, 0), 8),

                new Parking(3, "Lakeview Parking", "Scenic views of the nearby lake.",
                        "image3.jpg", "789 Lakeview Avenue", "Chicago",
                        41.8781, -87.6298, LocalTime.of(7, 30), LocalTime.of(22, 0), 12),

                new Parking(4, "Downtown Garage", "Bustling downtown area convenience.",
                        "image4.jpg", "101 Broadway", "San Francisco",
                        37.7749, -122.4194, LocalTime.of(6, 0), LocalTime.of(23, 0), 15),

                new Parking(5, "Suburban Park", "Spacious suburban lot in a quiet neighborhood.",
                        "image5.jpg", "222 Oak Street", "Houston",
                        29.7604, -95.3698, LocalTime.of(7, 0), LocalTime.of(19, 30), 7)
        );
    }
}

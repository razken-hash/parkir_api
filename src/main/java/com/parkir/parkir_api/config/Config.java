package com.parkir.parkir_api.config;

import com.parkir.parkir_api.bookings.BookingService;
import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.parkings.entities.Address;
import com.parkir.parkir_api.parkings.entities.Floor;
import com.parkir.parkir_api.parkings.entities.Parking;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.parkings.services.AddressService;
import com.parkir.parkir_api.parkings.services.FloorService;
import com.parkir.parkir_api.parkings.services.ParkingService;
import com.parkir.parkir_api.parkings.services.ParkingSpotService;
import com.parkir.parkir_api.users.User;
import com.parkir.parkir_api.users.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.print.Book;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class Config {


    @Bean
    CommandLineRunner commandLineRunner(ParkingService parkingService, AddressService addressService, FloorService floorService, ParkingSpotService parkingSpotService, UserService userService, BookingService bookingService) {
        return args -> {

            List<Address> addresses = Stream.of(
                    new Address("123 Main Street", "New York",
                            40.7128, -74.0060),
                    new Address("456 Elm Street", "Los Angeles",
                            34.0522, -118.2437),
                    new Address("789 Lakeview Avenue", "Chicago",
                            41.8781, -87.6298),
                    new Address("101 Broadway", "San Francisco",
                            37.7749, -122.4194),
                    new Address("222 Oak Street", "Houston",
                            29.7604, -95.3698)
            ).map(addressService::createAddress).toList();

            List<Parking> parkings = Stream.of(
                    new Parking("Central Parking", "Conveniently located in the city center.",
                            "image1.jpg", addresses.get(0), LocalTime.of(8, 0), LocalTime.of(20, 0), 10D
                    ),

                    new Parking("Green Park", "Eco-friendly with electric vehicle charging stations.",
                            "image2.jpg", addresses.get(1), LocalTime.of(9, 0), LocalTime.of(18, 0), 8D
                    ),

                    new Parking("Lakeview Parking", "Scenic views of the nearby lake.",
                            "image3.jpg", addresses.get(2), LocalTime.of(7, 30), LocalTime.of(22, 0), 12D
                    ),

                    new Parking("Downtown Garage", "Bustling downtown area convenience.",
                            "image4.jpg", addresses.get(3), LocalTime.of(6, 0), LocalTime.of(23, 0), 15D
                    ),

                    new Parking("Suburban Park", "Spacious suburban lot in a quiet neighborhood.",
                            "image5.jpg", addresses.get(4), LocalTime.of(7, 0), LocalTime.of(19, 30), 7D
                    )
            ).map(parkingService::createParking).toList();

            List<Floor> floors =
                    Stream.of(
                            new Floor(1, "FloorA", "FloorA Description", parkings.get(0)),
                            new Floor(2, "FloorB", "FloorB Description", parkings.get(0)),
                            new Floor(3, "FloorC", "FloorC Description", parkings.get(0))
                    ).map(floorService::createFloor).toList();

            List<ParkingSpot> parkingSpots = List.of(
                    new ParkingSpot(1, floors.get(0)),
                    new ParkingSpot(2, floors.get(0)),
                    new ParkingSpot(3, floors.get(0)),
                    new ParkingSpot(4, floors.get(0)),
                    new ParkingSpot(5, floors.get(0)),
                    new ParkingSpot(1, floors.get(1)),
                    new ParkingSpot(2, floors.get(1)),
                    new ParkingSpot(3, floors.get(1)),
                    new ParkingSpot(4, floors.get(1)),
                    new ParkingSpot(5, floors.get(1)),
                    new ParkingSpot(1, floors.get(2)),
                    new ParkingSpot(2, floors.get(2)),
                    new ParkingSpot(3, floors.get(2)),
                    new ParkingSpot(4, floors.get(2)),
                    new ParkingSpot(5, floors.get(2))
            );

            parkingSpots.forEach(parkingSpotService::createParkingSpot);

            List<User> users = Stream.of(
                    new User("ka_kenniche@esi.dz", "12345678"),
                    new User("kr_baaguigui@esi.dz", "12345678")
            ).map(userService::registerUser).toList();

            List<Booking> bookings = Stream.of(
                    new Booking(LocalDate.of(2020, 12, 24), LocalTime.of(9, 0, 0), LocalTime.of(22, 0, 0), Duration.ofHours(11), users.get(0), parkingSpots.get(1)),
                    new Booking(LocalDate.of(2021, 12, 24), LocalTime.of(9, 0, 0), LocalTime.of(22, 0, 0), Duration.ofHours(11), users.get(0), parkingSpots.get(1)),
                    new Booking(LocalDate.of(2022, 12, 24), LocalTime.of(9, 0, 0), LocalTime.of(22, 0, 0), Duration.ofHours(11), users.get(1), parkingSpots.get(2))
            ).map(bookingService::bookParking).toList();
        };
    }
}


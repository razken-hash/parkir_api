package com.parkir.parkir_api.config;

import com.parkir.parkir_api.booking_payments.BookingPayment;
import com.parkir.parkir_api.booking_payments.BookingPaymentService;
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
    CommandLineRunner commandLineRunner(ParkingService parkingService, AddressService addressService, FloorService floorService, ParkingSpotService parkingSpotService, UserService userService, BookingService bookingService, BookingPaymentService bookingPaymentService) {
        return args -> {

            List<Address> addresses = Stream.of(
                    new Address("123 Main Street", "New York",
                            27.9766155, -0.20396),
                    new Address("456 Elm Street", "Los Angeles",
                            36.1691245, 1.3539002),
                    new Address("789 Lakeview Avenue", "Chicago",
                            36.7538259, 3.057841),
                    new Address("101 Broadway", "San Francisco",
                            36.4803023, 2.8009379),
                    new Address("222 Oak Street", "Houston",
                            36.5980966, 2.4085379)
            ).map(addressService::createAddress).toList();

            List<Parking> parkings = Stream.of(
                    new Parking("Central Parking", "Conveniently located in the city center. It's near to the most needed services including hospitals, university, schools and administrations. It also offers a good welcoming as well as a driving guider.",
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


            List<BookingPayment> payments = Stream.of(
                    new BookingPayment(
                            "1234567890123456",
                            "123",
                            "12/25",
                            120D,
                            LocalDate.of(2024, 12, 23),
                            LocalTime.of(12, 34, 23)
                    )
            ).map(
                    bookingPaymentService::payBooking).toList();

            List<Booking> bookings = Stream.of(
                    new Booking(LocalDate.of(2020, 12, 24), LocalTime.of(9, 0, 0), LocalTime.of(22, 0, 0), Duration.ofHours(11), users.get(0), parkingSpots.get(1), payments.get(0)),
                    new Booking(LocalDate.of(2021, 12, 24), LocalTime.of(9, 0, 0), LocalTime.of(22, 0, 0), Duration.ofHours(11), users.get(0), parkingSpots.get(1), null),
                    new Booking(LocalDate.of(2022, 12, 24), LocalTime.of(9, 0, 0), LocalTime.of(22, 0, 0), Duration.ofHours(11), users.get(1), parkingSpots.get(2), null)
            ).map(bookingService::bookParking).toList();
        };
    }
}


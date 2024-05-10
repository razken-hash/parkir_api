package com.parkir.parkir_api.bookings;

import com.parkir.parkir_api.ParkirConsts;
import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.bookings.entities.BookingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{userId}")
    public List<Booking> getAllBookings(@PathVariable("userId") Integer userId) {
        return bookingService.getAllBookings(userId);
    }

    @GetMapping("/{userId}/{status}")
    public List<Booking> getBookingsByStatus(@PathVariable("userId") Integer userId, @PathVariable("status") BookingStatus bookingStatus) {
        return bookingService.getBookingsByStatus(userId, bookingStatus);
    }

    @GetMapping("/id={bookingId}")
    public Booking getBookingById(@PathVariable("bookingId") Integer bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PostMapping("/book")
    public Booking bookParking(@RequestBody Booking booking) {
        return new Booking();
    }

    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable("bookingId") Integer bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
}

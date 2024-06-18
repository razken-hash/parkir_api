package com.parkir.parkir_api.bookings;

import com.parkir.parkir_api.ParkirConsts;
import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.bookings.entities.BookingStatus;
import com.parkir.parkir_api.notifications.MessageNotification;
import com.parkir.parkir_api.notifications.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{userId}/id={bookingId}")
    public Booking getBookingById(@PathVariable("userId") Integer userId, @PathVariable("bookingId") Integer bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PostMapping("/book")
    public Booking bookParking(@RequestBody Booking booking) {
        return bookingService.bookParking(booking);
    }

    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable("bookingId") Integer bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

//    @Autowired
//    NotificationService firebaseMessagingService;
//
//    public void function() {
//        firebaseMessagingService.sendNotificationByToken();
//    }
}


//@Scheduled(cron = "0 5/* * * *", zone = "Africa/Algiers")

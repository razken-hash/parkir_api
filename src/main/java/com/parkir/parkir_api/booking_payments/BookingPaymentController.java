package com.parkir.parkir_api.booking_payments;

import com.parkir.parkir_api.ParkirConsts;
import com.parkir.parkir_api.bookings.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/bookings_payments")
public class BookingPaymentController {
    private final BookingPaymentService bookingPaymentService;

    @Autowired
    public BookingPaymentController(BookingPaymentService bookingPaymentService) {
        this.bookingPaymentService = bookingPaymentService;
    }

    @PostMapping("/pay")
    public BookingPayment pay(@RequestBody BookingPayment bookingPayment) {
        return bookingPaymentService.payBooking(bookingPayment);
    }
}

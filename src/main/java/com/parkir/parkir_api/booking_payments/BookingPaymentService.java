package com.parkir.parkir_api.booking_payments;

import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.bookings.entities.BookingStatus;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.users.User;
import com.parkir.parkir_api.users.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingPaymentService {
    private final BookingPaymentRepository bookingPaymentRepository;

    @Autowired
    public BookingPaymentService(BookingPaymentRepository bookingPaymentRepository) {
        this.bookingPaymentRepository = bookingPaymentRepository;
    }

    public BookingPayment payBooking(BookingPayment bookingPayment) {
        return bookingPaymentRepository.save(bookingPayment);
    }
}

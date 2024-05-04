package com.parkir.parkir_api.bookings;

import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.bookings.entities.BookingStatus;
import com.parkir.parkir_api.parkings.entities.Parking;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.parkings.repositories.FloorRepository;
import com.parkir.parkir_api.users.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings(Integer userId) {
        User user = new User();
        return bookingRepository.findBookingsByUser(user).get();
    }

    public List<Booking> getBookingsByStatus(Integer userId, BookingStatus bookingStatus) {
        List<Booking> bookings = getAllBookings(userId);
        return bookings.stream().filter(
                booking ->
                        booking.getStatus().equals(bookingStatus)
        ).collect(Collectors.toList());
    }

    public Booking bookParking(Booking booking) {
        Boolean isBookingAvailable = true;
        if (!isBookingAvailable) {
            throw new IllegalStateException("Booking Not Available");
        }
        return bookingRepository.save(booking);
    }

    @Transactional
    public Booking cancelBooking(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new IllegalStateException("Booking not exist"));
        if (booking.getBookingPayment() != null) {
            booking.setBookingPayment(null);
        } else {
            throw new IllegalStateException("Booking already cancelled");
        }
        return booking;
    }

    public Boolean getParkingSpotStatus(ParkingSpot parkingSpot, LocalTime beginTime, LocalTime endTime, LocalDate date) {
        return !bookingRepository.existsByParkingSpotAndBeginTimeAndEndTimeAndDate(parkingSpot, beginTime, endTime, date);
    }
}

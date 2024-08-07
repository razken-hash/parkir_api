package com.parkir.parkir_api.bookings;

import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.bookings.entities.BookingStatus;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.users.User;
import com.parkir.parkir_api.users.UserRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    public List<Booking> getAllBookings(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User Not Exist"));
        return bookingRepository.findBookingsByUser(user).orElseThrow(() -> new IllegalStateException("Error"));
    }

    public Booking getBookingById(Integer bookingId) {
        return bookingRepository.findBookingsById(bookingId).get();
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

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

//    public Boolean getParkingSpotStatus(ParkingSpot parkingSpot, LocalTime beginTime, LocalTime endTime, LocalDate date) {
//        return !bookingRepository.existsByParkingSpotAndBeginTimeAndEndTimeAndDate(parkingSpot, beginTime, endTime, date);
//    }
}

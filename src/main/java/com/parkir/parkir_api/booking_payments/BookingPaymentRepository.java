package com.parkir.parkir_api.booking_payments;

import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingPaymentRepository extends JpaRepository<BookingPayment, Integer> {
}
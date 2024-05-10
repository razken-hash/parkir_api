package com.parkir.parkir_api.bookings;

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
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    public Optional<List<Booking>> findBookingsByUser(User user);

    public Optional<Booking> findBookingsById(Integer bookingId);

    public Boolean existsByParkingSpotAndBeginTimeAndEndTimeAndDate(ParkingSpot parkingSpot, LocalTime beginTime, LocalTime endTime, LocalDate date);
}
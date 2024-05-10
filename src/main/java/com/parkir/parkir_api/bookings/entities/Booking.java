package com.parkir.parkir_api.bookings.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.parkir.parkir_api.booking_payments.BookingPayment;
import com.parkir.parkir_api.parkings.entities.ParkingSpot;
import com.parkir.parkir_api.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @SequenceGenerator(name = "booking_sequence", sequenceName = "booking_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
    private Integer id;

    LocalDate date;
    LocalTime beginTime;
    LocalTime endTime;
    Duration duration;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"bookmarks", "bookings", "payments"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "parking_spot_id")
    private ParkingSpot parkingSpot;

    @OneToOne
    @JoinColumn(name = "booking_payment_id")
    private BookingPayment bookingPayment;

    public Booking(LocalDate date, LocalTime beginTime, LocalTime endTime, Duration duration, User user, ParkingSpot parkingSpot, BookingPayment bookingPayment) {
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.duration = duration;
        this.user = user;
        this.parkingSpot = parkingSpot;
        this.bookingPayment = bookingPayment;
    }

    @JsonProperty("status")
    public BookingStatus getStatus() {
        if (bookingPayment == null) {
            return BookingStatus.Canceled;
        }
        if (LocalTime.now().isAfter(endTime)) {
            return BookingStatus.Completed;
        }
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isAfter(endTime)) {
            return BookingStatus.OnGoing;
        }
        return BookingStatus.Paid;
    }
}



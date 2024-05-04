package com.parkir.parkir_api.bookings.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parkir.parkir_api.parkings.entities.Place;
//import com.parkir.parkir_api.payments.entities.Payment;
//import com.parkir.parkir_api.users.entities.User;
import com.parkir.parkir_api.payments.entities.Payment;
import com.parkir.parkir_api.users.entities.User;
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
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToOne
    @JoinColumn(name = "payment_id")
    @JsonIgnoreProperties({"user"})
    private Payment payment;

    public Booking(LocalDate date, LocalTime beginTime, LocalTime endTime, Duration duration, User user, Place place) {
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.duration = duration;
        this.user = user;
        this.place = place;
    }
}

package com.parkir.parkir_api.bookings;

import com.parkir.parkir_api.parkings.models.Place;
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
    Place place;
}

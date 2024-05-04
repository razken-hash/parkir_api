package com.parkir.parkir_api.payments.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.parkir.parkir_api.users.entities.User;
import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.users.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_sequence", sequenceName = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence")
    private Long id;

    private String cardNumber;
    private String cardCVC;
    private String cardDate;
    private Double amount;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"bookings", "payments"})
    private User user;

    @OneToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnoreProperties({"payment", "user"})
    private Booking booking;
}

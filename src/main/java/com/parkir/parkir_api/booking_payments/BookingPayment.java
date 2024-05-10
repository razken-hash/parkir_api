package com.parkir.parkir_api.booking_payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parkir.parkir_api.bookings.entities.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "booking_payments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingPayment {
    @Id
    @SequenceGenerator(name = "payment_sequence", sequenceName = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence")
    private Long id;

    private String cardNumber;

    @Column(name = "card_cvc")
    private String cardCVC;
    private String cardDate;
    private Double amount;
    private LocalDate date;
    private LocalTime time;

    @OneToOne
    @JsonIgnoreProperties({"bookingPayment", "user"})
    @Transient
    private Booking booking;

    public BookingPayment(
            String cardNumber,
            String cardCVC,
            String cardDate,
            Double amount,
            LocalDate date,
            LocalTime time
    ) {
        this.cardNumber = cardNumber;
        this.cardCVC = cardCVC;
        this.cardDate = cardDate;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }
}

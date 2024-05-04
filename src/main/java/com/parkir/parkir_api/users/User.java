package com.parkir.parkir_api.users;

import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.booking_payments.BookingPayment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Integer id;

    private String email;
    private String hashedPassword;
    private String phoneNumber;
    private String name;
    private String gender;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookingPayment> bookingPayments;

    public User(String email, String hashedPassword) {
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public User(String email, String phoneNumber, String name, String gender) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.gender = gender;
    }
}

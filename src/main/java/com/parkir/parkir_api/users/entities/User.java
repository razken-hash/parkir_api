package com.parkir.parkir_api.users.entities;

import com.parkir.parkir_api.bookings.entities.Booking;
import com.parkir.parkir_api.parkings.entities.Parking;
import com.parkir.parkir_api.payments.entities.Payment;
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
    private List<Payment> payments;
}

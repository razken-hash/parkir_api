package com.parkir.parkir_api.parkings.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Integer id;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parking parking;

    private String street;
    private String city;
    private Double longitude;
    private Double latitude;

    public Address(
            String street, String city, Double longitude, Double latitude
    ) {
        this.street = street;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

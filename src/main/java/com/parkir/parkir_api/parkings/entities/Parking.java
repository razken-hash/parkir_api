package com.parkir.parkir_api.parkings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "parkings")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Parking {
    @Id
    @SequenceGenerator(name = "parking_sequence", sequenceName = "parking_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_sequence")
    private Integer id;

    private String name;
    private String description;
    private String image;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private LocalTime openingTime;
    private LocalTime closingTime;
    private Double pricePerHour;

    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Floor> floors = new ArrayList<>();

    public Parking(String name, String description, String image, Address address, LocalTime openingTime, LocalTime closingTime, Double pricePerHour) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.pricePerHour = pricePerHour;
    }


}

package com.parkir.parkir_api.parkings.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parkir.parkir_api.users.entities.User;
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
    private String address;
    private String city;
    private Double longitude;
    private Double latitude;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Double pricePerHour;

    @OneToMany(mappedBy = "parking", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Floor> floors = new ArrayList<>();

    public Parking(String name, String description, String image, String address, String city, Double longitude, Double latitude, LocalTime openingTime, LocalTime closingTime, Double pricePerHour) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.pricePerHour = pricePerHour;
    }
}

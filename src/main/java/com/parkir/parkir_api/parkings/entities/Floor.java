package com.parkir.parkir_api.parkings.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "floors")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Floor {
    @Id
    @SequenceGenerator(
            name = "floor_sequence",
            sequenceName = "floor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "floor_sequence"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<ParkingSpot> parkingSpots;

    private Integer number;
    private String name;
    private String description;

    @Transient
    private Integer parkingSpotsCount;

    @Transient
    private Integer availableParkingSpotsCount;

    public Floor(Integer number, String name, String description, Parking parking) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.parking = parking;
    }
}

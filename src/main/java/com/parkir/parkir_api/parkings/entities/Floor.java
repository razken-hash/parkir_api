package com.parkir.parkir_api.parkings.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("floors")
    private Parking parking;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Place> places;

    private Integer number;
    private String name;
    private String description;

    @Transient
    private Integer nbPlaces;

    @Transient
    private Integer nbAvailablePlaces;

    public Floor(Integer number, String name, String description) {
        this.number = number;
        this.name = name;
        this.description = description;
    }

    public Floor(Integer number, String name, String description, Parking parking) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.parking = parking;
    }

    public Floor(Integer number, String name, String description, List<Place> places) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.places = places;
    }

    public Floor(Integer number, String name, String description, Parking parking, List<Place> places) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.parking = parking;
        this.places = places;
    }

    public Integer getNbPlaces() {
        if (places == null) {
            return 0;
        }
        return places.size();
    }
}

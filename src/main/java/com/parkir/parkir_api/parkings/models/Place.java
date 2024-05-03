package com.parkir.parkir_api.parkings.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "places")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    @Id
    @SequenceGenerator(
            name = "place_sequence",
            sequenceName = "place_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "place_sequence"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    @JsonIgnoreProperties({"places", "parking"})
    private Floor floor;

    private Integer number;

    @Transient
    private Boolean status;

    public Place(Integer number) {
        this.number = number;
    }

    public Place(Integer number, Floor floor) {
        this.number = number;
        this.floor = floor;
    }
}

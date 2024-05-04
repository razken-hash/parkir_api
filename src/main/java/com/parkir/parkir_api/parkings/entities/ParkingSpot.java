package com.parkir.parkir_api.parkings.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "parking_spot")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpot {
    @Id
    @SequenceGenerator(
            name = "parking_spot_sequence",
            sequenceName = "parking_spot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "parking_spot_sequence"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    @JsonIgnoreProperties({"parkingSpots"})
    private Floor floor;

    private Integer number;

    @Transient
    private Boolean status;

    public ParkingSpot(Integer number) {
        this.number = number;
    }

    public ParkingSpot(Integer number, Floor floor) {
        this.number = number;
        this.floor = floor;
    }
}

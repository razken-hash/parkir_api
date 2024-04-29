package com.parkir.parkir_api.parkings;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity // This one is for Hibernate
@Table(name = "parkings") // This one is for Database
public class Parking {
    @Id
    @SequenceGenerator(
            name = "parking_sequence",
            sequenceName = "parking_sequence",
            allocationSize = 1
//            initialValue = 1,
//            schema = "public"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "parking_sequence"
    )
    private Integer id;
    private String name;
    private String description;
    private String images;
    private String address;
    private String city;
    private Double longitude;
    private Double latitude;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Integer pricePerHour;

    public Parking() {
    }

    public Parking(Integer id, String name, String description, String images, String address, String city, Double longitude, Double latitude, LocalTime openingTime, LocalTime closingTime, Integer pricePerHour) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.pricePerHour = pricePerHour;
    }

    public Parking(String name, String description, String images, String address, String city, Double longitude, Double latitude, LocalTime openingTime, LocalTime closingTime, Integer pricePerHour) {
        this.name = name;
        this.description = description;
        this.images = images;
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.pricePerHour = pricePerHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public Integer getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Integer pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}

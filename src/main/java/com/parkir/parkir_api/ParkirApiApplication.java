package com.parkir.parkir_api;

import com.parkir.parkir_api.parkings.Parking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
@RestController
public class ParkirApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkirApiApplication.class, args);
    }


}

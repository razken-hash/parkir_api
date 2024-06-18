package com.parkir.parkir_api;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.parkir.parkir_api.notifications.MessageNotification;
import com.parkir.parkir_api.notifications.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class ParkirApiApplication {

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream (new ClassPathResource("firebase-service-account.json").getInputStream ()) ;
        FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials (googleCredentials).build();
        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
        return FirebaseMessaging.getInstance (app);
    }

    public static void main(String[] args) {
        SpringApplication.run(ParkirApiApplication.class, args);
    }

    @Scheduled(cron = "0 */5 * * * ?", zone = "Africa/Algiers")
    public void function() {
        System.out.println("Hi there");
    }
}

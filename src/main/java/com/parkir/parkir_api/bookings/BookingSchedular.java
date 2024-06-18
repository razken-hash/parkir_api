package com.parkir.parkir_api.bookings;

import com.parkir.parkir_api.notifications.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
//public class BookingSchedular {
//    @Autowired
//    private NotificationService notificationService;
//
//    @Scheduled(cron = "0 5/* * * *", zone = "Africa/Algiers")
//    public void invokeScheduled() {
//        notificationService.sendNotificationByToken();
//    }
//}

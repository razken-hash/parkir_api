package com.parkir.parkir_api.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    NotificationService firebaseMessagingService;
    @PostMapping
    public String sendNotificationByToken(@RequestBody MessageNotification messageNotification) {
       return  firebaseMessagingService.sendNotificationByToken(messageNotification);
    }
}
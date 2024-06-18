package com.parkir.parkir_api.notifications;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public String sendNotificationByToken(MessageNotification notificationMessage) {
        Notification notification = Notification
                .builder()
                .setTitle(notificationMessage.getTitle())
                .setBody(notificationMessage.getBody())
                .setImage(notificationMessage.getImage()).build();

        Message message = Message
                .builder()
                .setToken(notificationMessage.getToken()).setNotification(notification)
                .putAllData(notificationMessage.getData()).build();


        try {
            firebaseMessaging.send(message);
            return "Success";
        } catch (Exception e) {
            return "Failure";
        }
    }
}
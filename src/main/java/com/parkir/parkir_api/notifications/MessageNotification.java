package com.parkir.parkir_api.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Data
@AllArgsConstructor
public class MessageNotification {
    private String token;
    private String title;
    private String body;
    private String image;
    private Map<String, String> data;
}
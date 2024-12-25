package com.example.OrdersAndNotificationsManager.Notifications;

import java.util.HashMap;
import java.util.Map;

public class NotificationTemplate {
    private String id; // Template ID
    private String content; // Template content with placeholders
    private Map<String, String> placeholders; // Dynamic placeholders

    // Constructor
    public NotificationTemplate(String id, String content) {
        this.id = id;
        this.content = content;
        this.placeholders = new HashMap<>();
    }

    // Add placeholder
    public void addPlaceholder(String key, String value) {
        placeholders.put(key, value);
    }

    // Generate final content
    public String generateContent() {
        String result = content;
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            result = result.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return result;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

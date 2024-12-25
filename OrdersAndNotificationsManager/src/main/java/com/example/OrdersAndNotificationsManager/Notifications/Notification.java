package com.example.OrdersAndNotificationsManager.Notifications;

public class Notification {
    private String id; // Unique ID for the notification
    private String recipient; // Email or phone number
    private String content; // Final content to be sent
    private String channel; // E.g., "Email" or "SMS"
    private boolean sent; // Status of the notification

    // Constructor
    public Notification(String id, String recipient, String content, String channel) {
        this.id = id;
        this.recipient = recipient;
        this.content = content;
        this.channel = channel;
        this.sent = false;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}

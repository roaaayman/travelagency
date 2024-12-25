package com.example.OrdersAndNotificationsManager.Notifications;
package Notifications;

public class SMSNotificationObserver implements NotificationObserver {
    @Override
    public void update(Notification notification) {
        // Here, simulate sending an SMS
        System.out.println("SMS sent to: " + notification.getRecipient() + " with content: " + notification.getContent());
    }
}

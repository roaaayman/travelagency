package com.example.OrdersAndNotificationsManager.Notifications;

public class EmailNotificationObserver implements NotificationObserver {
    @Override
    public void update(Notification notification) {
        System.out.println("Email sent to: " + notification.getRecipient());
    }
}

package com.example.OrdersAndNotificationsManager.Notifications;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private NotificationQueue notificationQueue;
    private List<Notification> sentNotifications;

    public NotificationService() {
        this.notificationQueue = new NotificationQueue();
        this.sentNotifications = new ArrayList<>();
    }

    // Create a notification
    public void createNotification(String recipient, String content, String channel) {
        Notification notification = new Notification(
                String.valueOf(System.currentTimeMillis()), recipient, content, channel
        );
        notificationQueue.enqueue(notification);
    }

    // Send notifications from queue
    public void sendNotifications() {
        while (!notificationQueue.isEmpty()) {
            Notification notification = notificationQueue.dequeue();
            if ("Email".equals(notification.getChannel())) {
                System.out.println("Sending Email to " + notification.getRecipient());
            } else if ("SMS".equals(notification.getChannel())) {
                System.out.println("Sending SMS to " + notification.getRecipient());
            }
            notification.setSent(true);
            sentNotifications.add(notification);
        }
    }

    // Get sent notifications
    public List<Notification> getSentNotifications() {
        return sentNotifications;
    }
}

package com.example.OrdersAndNotificationsManager.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/create")
    public String createNotification(@RequestParam String recipient, @RequestParam String content, @RequestParam String channel) {
        notificationService.createNotification(recipient, content, channel);
        return "Notification created.";
    }

    @GetMapping("/send")
    public String sendNotifications() {
        notificationService.sendNotifications();
        return "Notifications sent.";
    }

    @GetMapping("/stats")
    public List<Notification> getSentNotifications() {
        return notificationService.getSentNotifications();
    }
}

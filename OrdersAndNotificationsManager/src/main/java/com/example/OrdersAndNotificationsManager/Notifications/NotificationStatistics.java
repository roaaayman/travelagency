package com.example.OrdersAndNotificationsManager.Notifications;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationStatistics {
    public Map<String, Integer> calculateStatistics(List<Notification> notifications) {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Total Sent", notifications.size());
        return stats;
    }
}

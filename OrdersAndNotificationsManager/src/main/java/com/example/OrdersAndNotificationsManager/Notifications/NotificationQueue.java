package com.example.OrdersAndNotificationsManager.Notifications;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationQueue {
    private Queue<Notification> queue;

    public NotificationQueue() {
        this.queue = new LinkedList<>();
    }

    // Add notification to queue
    public void enqueue(Notification notification) {
        queue.add(notification);
    }

    // Retrieve notification from queue
    public Notification dequeue() {
        return queue.poll();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

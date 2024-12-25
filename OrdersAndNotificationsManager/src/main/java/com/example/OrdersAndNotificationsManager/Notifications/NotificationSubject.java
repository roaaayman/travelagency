package com.example.OrdersAndNotificationsManager.Notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationSubject {
    private List<NotificationObserver> observers;

    public NotificationSubject() {
        observers = new ArrayList<>();
    }

    // Register observer
    public void registerObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    // Notify observers
    public void notifyObservers(Notification notification) {
        for (NotificationObserver observer : observers) {
            observer.update(notification);
        }
    }
}

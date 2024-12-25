package com.example.OrdersAndNotificationsManager.Events;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExternalEventAPIAdapter {
    // Simulating fetching events from an external API
    public List<Event> fetchEvents() {
        // Mocked data for external events
        List<Event> externalEvents = new ArrayList<>();
        externalEvents.add(new Event("E101", "Food Festival", "Cairo", "2024-12-22", 150.0));
        externalEvents.add(new Event("E102", "Tech Conference", "Cairo", "2024-12-30", 1000.0));
        return externalEvents;
    }
}

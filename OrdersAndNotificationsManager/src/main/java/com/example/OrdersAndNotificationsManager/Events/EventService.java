package com.example.OrdersAndNotificationsManager.Events;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private List<Event> eventList = new ArrayList<>();
    private final ExternalEventAPIAdapter externalEventAPIAdapter;

    // Constructor Injection
    public EventService(ExternalEventAPIAdapter externalEventAPIAdapter) {
        this.externalEventAPIAdapter = externalEventAPIAdapter;

        // Preload some events for testing
        this.eventList.add(new Event("E001", "Concert", "Cairo", "2024-12-25", 500.0));
        this.eventList.add(new Event("E002", "Art Exhibition", "Alexandria", "2024-12-20", 200.0));
    }

    // Fetch all events (including external ones)
    public List<Event> getAllEvents() {
        List<Event> externalEvents = externalEventAPIAdapter.fetchEvents();
        List<Event> allEvents = new ArrayList<>(eventList);
        allEvents.addAll(externalEvents);
        return allEvents;
    }

    // Search for events by location
    public List<Event> searchEventsByLocation(String location) {
        return getAllEvents().stream()
                .filter(event -> event.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    // Get event details by ID
    public Event getEventById(String id) {
        return getAllEvents().stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add a new event (admin functionality)
    public void addEvent(Event event) {
        eventList.add(event);
    }
}

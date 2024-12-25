package com.example.OrdersAndNotificationsManager.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // Get all events
    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Search events by location
    @GetMapping("/search")
    public List<Event> searchEvents(@RequestParam String location) {
        return eventService.searchEventsByLocation(location);
    }

    // Get event details by ID
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            return event;
        } else {
            throw new RuntimeException("Event not found with ID: " + id);
        }
    }

    // Add a new event (Admin API)
    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
        return "Event added successfully!";
    }
}

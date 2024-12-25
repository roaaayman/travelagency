package com.example.OrdersAndNotificationsManager.Events;

public class Event {
    private String id;
    private String name;
    private String location;
    private String date; // In format YYYY-MM-DD
    private double price;

    // Constructors
    public Event() {}

    public Event(String id, String name, String location, String date, double price) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.price = price;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

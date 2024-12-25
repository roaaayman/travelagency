package com.example.OrdersAndNotificationsManager.Hotels;

public class Hotel {
    private String id; // Unique ID for the hotel
    private String name;
    private String location;
    private double rating;
    private double balance; // For any financial tracking

    // Constructors
    public Hotel() {}

    public Hotel(String id, String name, String location, double rating, double balance) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.balance = balance;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

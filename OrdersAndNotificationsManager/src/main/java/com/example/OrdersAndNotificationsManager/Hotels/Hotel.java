package com.example.OrdersAndNotificationsManager.Hotels;

import java.util.List;

public class Hotel {
    private String id; // Unique ID for the hotel
    private String name;
    private String location;
    private double rating; // 0.0 to 5.0
    private double balance; // For financial tracking
    private List<RoomType> roomTypes; // List of available room types in the hotel

    // Constructors
    public Hotel() {}

    public Hotel(String id, String name, String location, double rating, double balance, List<RoomType> roomTypes) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.balance = balance;
        this.roomTypes = roomTypes;
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
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }
}

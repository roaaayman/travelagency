package com.example.OrdersAndNotificationsManager.Hotels;

public class RoomType {
    private String type; // e.g., Single, Double, Suite
    private double pricePerNight;
    private int availableRooms;

    // Constructors
    public RoomType() {}

    public RoomType(String type, double pricePerNight, int availableRooms) {
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.availableRooms = availableRooms;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    // ToString for easy debugging
    @Override
    public String toString() {
        return "RoomType{" +
                "type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", availableRooms=" + availableRooms +
                '}';
    }
}

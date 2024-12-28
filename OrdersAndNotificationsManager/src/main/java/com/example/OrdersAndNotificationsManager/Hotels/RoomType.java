package com.example.OrdersAndNotificationsManager.Hotels;

import java.util.Objects;

public class RoomType {
    private String roomId; // Unique identifier for the room type
    private String type;   // e.g., Single, Double, Suite
    private double pricePerNight;
    private int availableRooms;

    // Constructors
    public RoomType() {}

    public RoomType(String roomId, String type, double pricePerNight, int availableRooms) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerNight = pricePerNight >= 0 ? pricePerNight : 0;
        this.availableRooms = availableRooms >= 0 ? availableRooms : 0;
    }

    // Getters and Setters
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

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
        if (pricePerNight < 0) {
            throw new IllegalArgumentException("Price per night cannot be negative.");
        }
        this.pricePerNight = pricePerNight;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        if (availableRooms < 0) {
            throw new IllegalArgumentException("Available rooms cannot be negative.");
        }
        this.availableRooms = availableRooms;
    }

    // Utility method to check availability
    public boolean isAvailable() {
        return availableRooms > 0;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(roomId, roomType.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }

    // ToString for debugging
    @Override
    public String toString() {
        return "RoomType{" +
                "roomId='" + roomId + '\'' +
                ", type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", availableRooms=" + availableRooms +
                '}';
    }
}

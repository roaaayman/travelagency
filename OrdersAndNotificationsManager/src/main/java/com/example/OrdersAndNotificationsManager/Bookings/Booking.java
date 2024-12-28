package com.example.OrdersAndNotificationsManager.Bookings;

import java.util.Date;

public class Booking {
    private String bookingId;  // Unique booking ID
    private String userId;  // User who made the booking
    private String hotelId;  // Associated hotel
    private String roomId;  // Associated room
    private String roomType;  // Type of room (e.g., "Deluxe", "Suite")
    private Date startDate;  // Start date of the booking
    private Date endDate;  // End date of the booking
    private String status;  // Booking status (e.g., "confirmed", "canceled", "pending")
    private double totalAmount;  // Total amount for the booking

    // Constructor
    public Booking(String bookingId, String userId, String hotelId, String roomId, String roomType, Date startDate, Date endDate, String status, double totalAmount) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

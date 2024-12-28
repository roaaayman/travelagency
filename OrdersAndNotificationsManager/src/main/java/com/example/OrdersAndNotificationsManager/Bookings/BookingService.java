package com.example.OrdersAndNotificationsManager.Bookings;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private List<Booking> bookings = new ArrayList<>();

    public void createBooking(String userId, String hotelId, String roomId, String roomType, String startDateStr, String endDateStr, double totalAmount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Parse start and end dates
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
    
            // Validate that the end date is after the start date
            if (endDate.before(startDate)) {
                throw new IllegalArgumentException("End date must be after start date.");
            }
    
            // Generate a unique booking ID
            String bookingId = String.valueOf(System.currentTimeMillis());
    
            // Create the booking
            Booking booking = new Booking(bookingId, userId, hotelId, roomId, roomType, startDate, endDate, "pending", totalAmount);
    
            // Add the booking to the list
            bookings.add(booking);
    
        } catch (ParseException e) {
            // Log and rethrow the exception or handle gracefully
            System.err.println("Error parsing dates: " + e.getMessage());
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.", e);
        } catch (IllegalArgumentException e) {
            // Handle invalid date range or other validation issues
            System.err.println("Error creating booking: " + e.getMessage());
            throw e;
        }
    }

    // Get booking by ID
    public Booking getBooking(String bookingId) {
        return bookings.stream()
                .filter(booking -> booking.getBookingId().equals(bookingId))
                .findFirst()
                .orElse(null);
    }

    // Get bookings by user ID
    public List<Booking> getBookingsByUser(String userId) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUserId().equals(userId)) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    // Cancel a booking
    public void cancelBooking(String bookingId) {
        Optional<Booking> bookingOpt = bookings.stream()
                .filter(booking -> booking.getBookingId().equals(bookingId))
                .findFirst();

        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus("canceled");
        }
    }
}

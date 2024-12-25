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

    // Create a new booking
    public void createBooking(String userId, String hotelId, String roomId, String startDateStr, String endDateStr, double totalAmount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            String bookingId = String.valueOf(System.currentTimeMillis());
            Booking booking = new Booking(bookingId, userId, hotelId, roomId, startDate, endDate, "pending", totalAmount);
            bookings.add(booking);
        } catch (ParseException e) {
            e.printStackTrace();
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

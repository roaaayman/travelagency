package com.example.OrdersAndNotificationsManager.Bookings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create a new booking
    @PostMapping("/create")
    public String createBooking(@RequestParam String userId,
                                @RequestParam String hotelId,
                                @RequestParam String roomId,
                                @RequestParam String startDate,
                                @RequestParam String endDate,
                                @RequestParam double totalAmount) {
        bookingService.createBooking(userId, hotelId, roomId, startDate, endDate, totalAmount);
        return "Booking created successfully.";
    }

    // Get booking by ID
    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable String bookingId) {
        return bookingService.getBooking(bookingId);
    }

    // Get all bookings for a user
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable String userId) {
        return bookingService.getBookingsByUser(userId);
    }

    // Cancel a booking
    @PutMapping("/{bookingId}/cancel")
    public String cancelBooking(@PathVariable String bookingId) {
        bookingService.cancelBooking(bookingId);
        return "Booking canceled.";
    }
}

package com.example.OrdersAndNotificationsManager.Bookings;

import com.example.OrdersAndNotificationsManager.Hotels.HotelService;
import com.example.OrdersAndNotificationsManager.Hotels.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final HotelService hotelService;

    @Autowired
    public BookingController(BookingService bookingService, HotelService hotelService) {
        this.bookingService = bookingService;
        this.hotelService = hotelService;
    }

    // Create a new booking
   @PostMapping("/create")
public String createBooking(@RequestBody Map<String, Object> bookingData) {
    String userId = (String) bookingData.get("userId");
    String hotelId = (String) bookingData.get("hotelId");
    String roomType = (String) bookingData.get("roomType");
    String startDate = (String) bookingData.get("startDate");
    String endDate = (String) bookingData.get("endDate");
    double totalAmount = Double.parseDouble(bookingData.get("totalAmount").toString());

    // Validate hotel existence
    Hotel hotel = hotelService.getHotelById(hotelId);
    if (hotel == null) {
        return "Hotel not found.";
    }

    // Check room availability
    if (!hotelService.checkRoomAvailability(hotelId, roomType)) {
        return "Room type is not available.";
    }

    // Get the roomId for the specified roomType
    String roomId = hotelService.getRoomIdForRoomType(hotelId, roomType);
    if (roomId == null) {
        return "Room ID not found for the specified room type.";
    }

    // Create booking
    bookingService.createBooking(userId, hotelId, roomId, roomType, startDate, endDate, totalAmount);

    // Decrease room availability
    boolean availabilityDecreased = hotelService.decreaseRoomAvailability(hotelId, roomType);
    if (!availabilityDecreased) {
        return "Failed to update room availability.";
    }

    return "Booking created successfully.";
}

    // Get booking by ID
    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable String bookingId) {
        Booking booking = bookingService.getBooking(bookingId);
        if (booking == null) {
            throw new IllegalArgumentException("Booking not found.");
        }
        return booking;
    }

    // Get all bookings for a user
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable String userId) {
        return bookingService.getBookingsByUser(userId);
    }

    // Cancel a booking
    @PutMapping("/{bookingId}/cancel")
    public String cancelBooking(@PathVariable String bookingId) {
        Booking booking = bookingService.getBooking(bookingId);
        if (booking == null) {
            return "Booking not found.";
        }

        // Increase room availability on cancellation
        hotelService.increaseRoomAvailability(booking.getHotelId(), booking.getRoomType());

        // Cancel booking
        bookingService.cancelBooking(bookingId);

        return "Booking canceled successfully.";
    }
}

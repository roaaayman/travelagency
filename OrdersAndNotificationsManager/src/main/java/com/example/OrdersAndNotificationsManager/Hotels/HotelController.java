package com.example.OrdersAndNotificationsManager.Hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public String createHotel(@RequestBody Hotel hotel) {
        if (hotelService.checkIdUniqueness(hotel.getId())) {
            hotelService.createHotel(hotel);
            return "Hotel created successfully.";
        } else {
            return "Hotel ID already exists.";
        }
    }

    @GetMapping("/check/{id}")
    public Hotel checkHotel(@PathVariable("id") String id) {
        return hotelService.getHotelById(id);
    }

    @PutMapping("/{id}/balance")
    public String updateBalance(@PathVariable String id, @RequestBody double balance) {
        Hotel hotel = hotelService.updateBalance(id, balance);
        if (hotel != null) {
            return "Balance updated successfully. New Balance: " + hotel.getBalance();
        } else {
            return "Hotel not found.";
        }
    }

    @GetMapping("/search")
    public List<Hotel> searchHotels(@RequestParam("keyword") String keyword) {
        return hotelService.searchHotels(keyword);
    }

    @PutMapping("/{id}/rooms")
    public String updateRoomAvailability(@PathVariable String id, @RequestParam String roomType, @RequestParam int availableRooms) {
        boolean updated = hotelService.updateRoomAvailability(id, roomType, availableRooms);
        return updated ? "Room availability updated." : "Hotel or room type not found.";
    }
}

package com.example.OrdersAndNotificationsManager.Hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

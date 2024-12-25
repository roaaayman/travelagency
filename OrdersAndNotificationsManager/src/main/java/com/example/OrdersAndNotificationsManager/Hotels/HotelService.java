package com.example.OrdersAndNotificationsManager.Hotels;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    private List<Hotel> hotelList = new ArrayList<>();

    // Create a new hotel
    public void createHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    // Retrieve hotel by ID
    public Hotel getHotelById(String id) {
        for (Hotel hotel : hotelList) {
            if (hotel.getId().equals(id)) {
                return hotel;
            }
        }
        return null;
    }

    // Update hotel balance
    public Hotel updateBalance(String id, double balance) {
        Hotel hotel = getHotelById(id);
        if (hotel != null) {
            hotel.setBalance(hotel.getBalance() + balance);
            return hotel;
        }
        return null;
    }

    // Check uniqueness of hotel ID
    public boolean checkIdUniqueness(String id) {
        for (Hotel hotel : hotelList) {
            if (hotel.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
}

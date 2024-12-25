package com.example.OrdersAndNotificationsManager.Hotels;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private List<Hotel> hotelList = new ArrayList<>();

    // Create a new hotel
    public void createHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    // Retrieve hotel by ID
    public Hotel getHotelById(String id) {
        return hotelList.stream()
                .filter(hotel -> hotel.getId().equals(id))
                .findFirst()
                .orElse(null);
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
        return hotelList.stream().noneMatch(hotel -> hotel.getId().equals(id));
    }

    // Search hotels by name, location, or rating
    public List<Hotel> searchHotels(String keyword) {
        return hotelList.stream()
                .filter(hotel -> hotel.getName().contains(keyword) || hotel.getLocation().contains(keyword))
                .collect(Collectors.toList());
    }

    // Update room availability
    public boolean updateRoomAvailability(String hotelId, String roomType, int availableRooms) {
        Hotel hotel = getHotelById(hotelId);
        if (hotel != null) {
            for (RoomType room : hotel.getRoomTypes()) {
                if (room.getType().equalsIgnoreCase(roomType)) {
                    room.setAvailableRooms(availableRooms);
                    return true;
                }
            }
        }
        return false;
    }
}

package com.taylor.reservation.service;

import com.taylor.reservation.domain.Hotel;
import com.taylor.reservation.domain.HotelCriteria;
import com.taylor.reservation.domain.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HotelService {

    public Collection<Hotel> search(HotelCriteria hotelCriteria) {
        List<Hotel> hotels = new ArrayList<Hotel>();
        Hotel hotel = new Hotel();
        hotels.add(hotel);
        Room room = new Room();
        room.setId(1);
        room.setHasWifi(true);
        room.setOutletNumber(15);
        room.setSeatsNumer(20);
        room.setPrice(1500);
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(room);
        hotel.setRooms(rooms);
        return hotels;
    }
}

package com.teamB;

import java.util.ArrayList;
import java.util.List;

public class RoomSearcher {


    public List<Room> search(String meeting, int i) {
        List<Room> rooms = new ArrayList<Room>();

        Room room = new Room();
        room.setCapiblity(10);
        room.setHotelName("CityHotel");
        room.setName("vip6");
        rooms.add(room);

        return rooms;
    }
}

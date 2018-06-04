package com.teamB;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    List<Room> rooms = new ArrayList<Room>();

    public RoomManager() {
        List<Room> rooms = new ArrayList<Room>();
        Room room = new Room();
        room.setPrice(200);
        room.setHotelName("CityHotel");
        room.setName("vip6");
        rooms.add(room);
        setRooms(rooms);
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> search(String name) {
        List<Room> results = new ArrayList<Room>();
        for (Room room : this.rooms ) {
            if (room.getName() == name)
            {
                results.add(room);
            }
        }
        return results;
    }
}

package com.teamB;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    List<Room> rooms = new ArrayList<Room>();

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room search(String name) {
        for (Room room : rooms ) {
            if (room.getName() == name)
            {
                return room;
            }
        }
        return new Room();
    }
}

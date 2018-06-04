package com.teamB;

import java.util.ArrayList;
import java.util.List;

public class RoomSearcher {


    public List<Room> search(String meeting, int i) {

        RoomManager rm = new RoomManager();
        List<Room> rooms = rm.search(meeting);

        return rooms;
    }
}

package example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MeetingRoomManager {
    private List<MeetingRoom> rooms = new ArrayList<>();

    public void addRoom(MeetingRoom room) {
        rooms.add(room);
    }

    public List<MeetingRoom> searchAvailable() {
        List<MeetingRoom> availableRooms = new ArrayList<>();

        for (Iterator<MeetingRoom> i = rooms.iterator(); i.hasNext();) {
            MeetingRoom room = i.next();
            if (room.isAvailable){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}

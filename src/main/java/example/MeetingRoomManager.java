package example;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomManager {
    private List<MeetingRoom> rooms = new ArrayList<>();

    public void addRoom(MeetingRoom room) {
        rooms.add(room);
    }

    public List<MeetingRoom> searchAvailable() {
        List<MeetingRoom> availableRooms = new ArrayList<>();

        for (MeetingRoom room : rooms) {
            if (room.isAvailable) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void initialize() {
        rooms.clear();
    }
}

package example.portal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thinkpad on 18-06-04.
 */
public class Meeting {

    private static List<Room> rooms = new ArrayList<>();

    public List<Room> search(RoomSearchEntity entity) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room());
        return rooms;
    }

    public void addRoom(User user, Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}

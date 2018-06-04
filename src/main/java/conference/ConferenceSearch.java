package conference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConferenceSearch {
    public List<Room> search(String addr) {
        List<Room> result = new ArrayList<Room>();
        List<Room> rooms = RoomDB.getRooms();
        if (null == addr){
            return rooms;
        }
        Room room;
        for (int i = 0; i < rooms.size(); i++) {
            room = rooms.get(i);
            if (addr.equals(room.getAddr())) {
                result.add(room);
            }
        }
        return result;
    }


    public List<Room> searchAndSortByPrice(String addr, String status) {
        List<Room> result = new ArrayList<Room>();
        List<Room> rooms = RoomDB.getRooms();
        Room room;
        for (int i = 0; i < rooms.size(); i++) {
            room = rooms.get(i);
            if (addr.equals(room.getAddr()) && status.equals(room.getStatus())) {
                result.add(room);
            }
        }
        Collections.sort(result);
        return result;

    }
}

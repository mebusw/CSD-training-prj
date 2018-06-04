package conference;

import java.util.ArrayList;
import java.util.List;

public class ConferenceSearch {
    public List<Room> search(String addr) {
        List<Room> result = new ArrayList<Room>();
        List<Room> rooms = RoomDB.getRooms();
        for (int i = 0; i < rooms.size(); i++)
            if (addr.equals(rooms.get(i).getAddr())) {
                result.add(rooms.get(i));
            }
        return result;
    }


    public List<Room> searchAndSortByPrice(String addr, String status) {
        List<Room> result = new ArrayList<Room>();
        List<Room> rooms = RoomDB.getRooms();
        for (int i = 0; i < rooms.size(); i++) {
        if (addr.equals(rooms.get(i).getAddr()) && status.equals(rooms.get(i).getStatus())) {
            result.add(rooms.get(i));
        }
        }
        return  result;

    }
}

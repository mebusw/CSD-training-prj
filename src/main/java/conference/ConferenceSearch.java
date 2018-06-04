package conference;

import java.util.ArrayList;
import java.util.List;

public class ConferenceSearch {
    public List<Room> search(String addr) {
        List<Room> rooms = RoomDB.getRooms();
        List<Room> result = new ArrayList<Room>();
        for (int i = 0; i < rooms.size(); i++)
            if (addr.equals(rooms.get(i).getAddr())) {
                result.add(rooms.get(i));
            }
        return result;
    }


}

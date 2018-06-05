package conference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConferenceSearch {
    private  IRoomDB roomDB;
    public ConferenceSearch(IRoomDB roomDB){
        if (null == roomDB ){
            this.roomDB =  new RoomDB();
        }else {
            this.roomDB = roomDB;
        }
    }
    public List<Room> search(String addr) {
        List<Room> result = new ArrayList<Room>();
        List<Room> rooms = roomDB.getRooms();
        if ("".equals(addr)){
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
        List<Room> rooms = roomDB.getRooms();
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

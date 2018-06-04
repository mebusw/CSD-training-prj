package conference;

import java.util.ArrayList;
import java.util.List;

public class RoomDB {
    public static List<Room> getRooms() {
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room("001","杭州",1000.00));
        rooms.add(new Room("002","上海",2000.00));
        rooms.add(new Room("003","北京",3000.00));
        return rooms;
    }
}

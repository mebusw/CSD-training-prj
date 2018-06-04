package conference;

import java.util.ArrayList;
import java.util.List;

public class RoomDB {
    public static List<Room> getRooms() {
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room("001","杭州",1000.00,"busy"));
        rooms.add(new Room("002","上海",2000.00,"busy"));
        rooms.add(new Room("003","北京",3000.00,"free"));
        rooms.add(new Room("004","杭州",800.00,"free"));
        rooms.add(new Room("005","杭州",3000.00,"free"));
        rooms.add(new Room("006","杭州",1200.00,"free"));
        return rooms;
    }
}

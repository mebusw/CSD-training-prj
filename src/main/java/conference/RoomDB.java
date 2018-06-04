package conference;

import java.util.ArrayList;
import java.util.List;

public class RoomDB {

    private  static List<Room> rooms = new ArrayList<Room>();
    static {
        rooms.add(new Room("001","杭州",1000.00,"busy"));
        rooms.add(new Room("002","上海",2000.00,"busy"));
        rooms.add(new Room("003","北京",3000.00,"free"));
        rooms.add(new Room("004","杭州",850.00,"free"));
        rooms.add(new Room("009","杭州",3000.00,"free"));
        rooms.add(new Room("005","杭州",2000.00,"free"));
        rooms.add(new Room("006","杭州",1200.00,"free"));
    }

    public static List<Room> getRooms() {
        return rooms;
    }
    public static boolean setSatusforbusy(String roomId){
        Room room;
        for (int i = 0; i < rooms.size(); i++) {
            room = rooms.get(i);
            if (roomId.equals(room.getRoomId())&& "free".equals(room.getStatus())){
                room.setStatus("busy");
                return true;
            }
        }
        return false;
    }
}

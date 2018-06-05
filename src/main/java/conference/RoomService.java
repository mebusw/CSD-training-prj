package conference;


import java.util.List;

public class RoomService {

    public static   boolean setStatusTobusy(String roomId, IRoomDB roomDB) {
        Room room;
        for (int i = 0; i < roomDB.getRooms().size(); i++) {
            room = roomDB.getRooms().get(i);
            if (roomId.equals(room.getRoomId()) && "free".equals(room.getStatus())) {
                room.setStatus("busy");
                return true;
            }
        }
        return false;
    }

}

package conference;

import java.util.List;

public class ConferenceReserve {
    public boolean reserve(String roomId) {
        List<Room> rooms = RoomDB.getRooms();
        Room room;
        for (int i = 0; i < rooms.size(); i++) {
            room = rooms.get(i);
            if (roomId.equals(room.getRoomId())){
                room.setStatus("busy");
                return true;
            }
        }
        return false;
    }
}

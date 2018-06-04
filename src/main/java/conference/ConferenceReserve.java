package conference;

import java.util.List;

public class ConferenceReserve {
    public RoomOrder reserve(RoomOrder roomOrder) {
        RoomOrder afterRoomOrder = new RoomOrder();
        afterRoomOrder.setRoomId(roomOrder.getRoomId());
        afterRoomOrder.setStartDate(roomOrder.getStartDate());
        afterRoomOrder.setEndDate(roomOrder.getEndDate());
        afterRoomOrder.setOrderStatus(RoomOrder.ORDER_STATUS_INITI);
        List<Room> rooms = RoomDB.getRooms();
        Room room;
        for (int i = 0; i < rooms.size(); i++) {
            room = rooms.get(i);
            if (roomOrder.getRoomId().equals(room.getRoomId())) {
                if (RoomDB.setSatusforbusy(roomOrder.getRoomId())) {
                    afterRoomOrder.setOrderStatus(RoomOrder.ORDER_STATUS_SUCCESS);
                } else {
                    afterRoomOrder.setOrderStatus(RoomOrder.ORDER_STATUS_FAIL);
                }
                break;
            }
        }
        return afterRoomOrder;
    }
}

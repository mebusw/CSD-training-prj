package conference;

import java.util.List;

public class ConferenceReserve {
    private  IRoomDB roomDB;
    public ConferenceReserve(IRoomDB roomDB){
        if (null == roomDB ){
            this.roomDB =  new RoomDB();
        }else {
            this.roomDB = roomDB;
        }
    }
    public RoomOrder reserve(RoomOrder roomOrder) {
        RoomOrder resultRoomOrder = new RoomOrder();
        resultRoomOrder.setRoomId(roomOrder.getRoomId());
        resultRoomOrder.setStartDate(roomOrder.getStartDate());
        resultRoomOrder.setEndDate(roomOrder.getEndDate());
        resultRoomOrder.setOrderStatus(RoomOrder.ORDER_STATUS_INITI);
        List<Room> rooms = roomDB.getRooms();
        Room room;
        for (int i = 0; i < rooms.size(); i++) {
            room = rooms.get(i);
            if (roomOrder.getRoomId().equals(room.getRoomId())) {
                if (RoomService.setStatusTobusy(roomOrder.getRoomId(),roomDB)) {
                    resultRoomOrder.setOrderStatus(RoomOrder.ORDER_STATUS_SUCCESS);
                } else {
                    resultRoomOrder.setOrderStatus(RoomOrder.ORDER_STATUS_FAIL);
                }
                break;
            }
        }
        return resultRoomOrder;
    }
}

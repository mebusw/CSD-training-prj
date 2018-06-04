package example

class RoomService {

    List<Room> roomList = new ArrayList()
    def put(Room room){
        roomList.add(room)
    }

    List<Room> query(boolean ordered) {
        List orderRoomList = new ArrayList();
        List noOrderRoomList = new ArrayList();

        for(Room room:roomList){

            if(room.ordered != null){
                orderRoomList.add(room)

            }else{
                noOrderRoomList.add(room)
            }
        }

        if(ordered){
            return orderRoomList
        }else{
            return noOrderRoomList
        }
   }
}

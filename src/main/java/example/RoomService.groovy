package example

class RoomService {

    List<Room> roomList = new ArrayList()
    def put(Room room){
        roomList.add(room)
    }

    List<Room> query(boolean ordered) {


        List orderRoomList = new ArrayList();
        List noOrderRoomList = new ArrayList();

        return roomList.findAll {
            (it.ordered != null) == ordered
        }.asList()
   }
}

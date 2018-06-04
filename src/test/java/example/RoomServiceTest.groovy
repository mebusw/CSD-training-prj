package example

import example.Room

class RoomServiceTest extends spock.lang.Specification{

    RoomService roomService
    def setup(){
        roomService=new RoomService()


    }

    def "查询已预定会议室"(){
        given:"会议预定系统里有3个已预定，2个未预定"
        def room1 = new Room()
        def room2 = new Room()
        def room3 = new Room()
        def room4 = new Room()
        def room5 = new Room()
        def coach = new Coach()
        roomService.put(room1)
        roomService.put(room2)
        roomService.put(room3)
        roomService.put(room4)
        roomService.put(room5)
        coach.order(room1)
        coach.order(room2)
        coach.order(room3)

        when :"查询已预定系统"
          List<Room> roomsOrdered =roomService.query(true)
          List<Room> roomsUnOrdered =roomService.query(false)
        then:"有3个预定的，2个未预定的"
        roomsOrdered.size()==3
        roomsUnOrdered.size()==2

    }

}

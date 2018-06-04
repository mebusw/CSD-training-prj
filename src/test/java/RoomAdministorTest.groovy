import example.Administor
import example.Room

class RoomAdministorTest extends spock.lang.Specification{

    def setup(){

    }

    def "测试调整会议室价格"(){
        given:"有个会议室管理员和一个会议室"
          Room room = new Room();
          Administor administor = new Administor();
        when :"指定某个会议室价格为101"
          administor.assign(room,101);
        then:"会议室价格为101"
          room.getPrice() == 101;


    }

}

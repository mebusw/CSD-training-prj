import example.Administor
import example.Room

class RoomAdministorTest extends spock.lang.Specification{

    Room room;
    Administor administor
    def setup(){
        room = new Room();
        administor = new Administor();

    }

    def "测试调整会议室价格"(){
        given:"有个会议室管理员和一个会议室"
        when :"指定某个会议室价格为101"
          administor.assign(room,101);
        then:"会议室价格为101"
          room.getSaledPrice() == 101;

    }

    def "发售优惠券"(){
        given:"有个会议室管理员和一个会议室"
          administor = new Administor();

        when:"管理员给room设定一个指定折扣的优惠券"
        administor.assign(room,300)
        administor.setCoupon(room,3)
        then:"会议室价格变为此折扣价"
        room.getSaledPrice() == 90;
    }

}

package example

import example.Administor
import example.Room

class CoachTest extends spock.lang.Specification{

    Room room;
    Coach coach
    Administor administor;
    def setup(){
        administor=new Administor()
        room = new Room()
        coach = new Coach()

    }

    def "Coach有会议室A的金卡"(){
        given:"有一个Coach并且会议室管理员给了这个人一张金卡"
        administor.giveGoldCardTp(coach)
        when :"某个会议室（价格默认300）"
        then:"会议室的价格对于LI为240"
        coach.getOrderPrice(room) == 240
        room.getActualPrice() ==300

    }

    def "Coach没有会议室A的金卡"(){
        given:""
        when :"某个会议室（价格默认300）"
        then:"会议室的价格对于LI为240"
        coach.getOrderPrice(room) == 300
        room.getActualPrice() ==300

    }




}

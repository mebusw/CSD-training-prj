package example;

import example.entity.HotelManager;
import example.entity.MeetingRoom;
import example.service.UserService;
import example.service.dto.RoomCondition;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoacherTest {

    private UserService userService = null;
    @Before
    public void setUp(){
        userService = new UserService();

        // 酒店1
        HotelManager cityHotelManager = new HotelManager("张三", "test@test.com", "13888888888");
        // 房间
        cityHotelManager.addMeetingRoom(new MeetingRoom("CityHotel","shanghai",20,800,false,"Anything"));
        cityHotelManager.addMeetingRoom(new MeetingRoom("CityHotel","shanghai",40,1200,false,"Anything"));
        cityHotelManager.addMeetingRoom(new MeetingRoom("CityHotel","shanghai",10,500,false,"Anything"));
        userService.add(cityHotelManager);


        // 酒店2
        HotelManager hantingHotelManager = new HotelManager("李四", "test@test.com", "13888888888");
        // 房间
        hantingHotelManager.addMeetingRoom(new MeetingRoom("HantingHotel","shanghai",15,900,false,"Anything"));
        hantingHotelManager.addMeetingRoom(new MeetingRoom("HantingHotel","shanghai",35,1500,false,"Anything"));
        hantingHotelManager.addMeetingRoom(new MeetingRoom("HantingHotel","shanghai",100,200,false,"Anything"));
        userService.add(hantingHotelManager);
    }

    @Test
    public void test_search_all() throws Exception {
        assertEquals(6, userService.getMeetingRooms().size());
    }


    @Test
    public void test_search_price_0_1000() throws Exception {

        RoomCondition roomCondition = new RoomCondition(0,1000,0,100);

        assertEquals(4, userService.getMeetingRooms(roomCondition).size());
    }


    @Test
    public void test_search_price_min_1000() throws Exception {

        RoomCondition roomCondition = new RoomCondition(1000,0,0,0);

        assertEquals(2, userService.getMeetingRooms(roomCondition).size());
    }

}
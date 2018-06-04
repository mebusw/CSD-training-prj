package example;

import example.entity.HotelManager;
import example.entity.MeetingRoom;
import org.junit.Assert;
import org.junit.Test;

public class MeetingRoomTest {

    @Test
    public void test_add_one_room(){
        HotelManager hotelManger = new HotelManager();
        MeetingRoom meetingRoom = new MeetingRoom();
        hotelManger.addMeetingRoom(meetingRoom);
        Assert.assertEquals(1,hotelManger.getMeetingRooms().size());

    }
    @Test
    public void test_add_two_room(){
        HotelManager hotelManger = new HotelManager();
        MeetingRoom meetingRoom = new MeetingRoom();
        MeetingRoom meetingRoom2 = new MeetingRoom();
        hotelManger.addMeetingRoom(meetingRoom);
        hotelManger.addMeetingRoom(meetingRoom2);
        Assert.assertEquals(2,hotelManger.getMeetingRooms().size());

    }

    @Test
    public void test_add_room_Props(){
        HotelManager hotelManger = new HotelManager();
        MeetingRoom meetingRoom = new MeetingRoom("CityHotel","shanghai","50","800",false,"Anything");
        hotelManger.addMeetingRoom(meetingRoom);
        Assert.assertEquals(1,hotelManger.getMeetingRooms().size());
        Assert.assertEquals("CityHotel",hotelManger.getMeetingRooms().get(0).getName());

    }
}

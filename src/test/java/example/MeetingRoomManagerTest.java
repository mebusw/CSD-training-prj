package example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomManagerTest {


    private String meetingRoomName;
    private String vendorName;

    @Before
    public void setup(){
        meetingRoomName = "meetingRoomName1";
        vendorName = "vendorName1";
    }

    @Test
    public void test_Search_All_Available_MeetingRooms(){
        // arrange
        MeetingRoomManager sut = new MeetingRoomManager();
        MeetingRoom room = new MeetingRoom(meetingRoomName, vendorName);
        sut.addRoom(room);

        ArrayList<MeetingRoom> expected = new ArrayList<>();
        expected.add(room);

        // act
        List<MeetingRoom> actual = sut.searchAvailable();

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void test_Search_All_Available_MeetingRooms_When_Some_Room_Is_Not_Available(){
        // arrange
        MeetingRoomManager sut = new MeetingRoomManager();
        MeetingRoom room = new MeetingRoom(meetingRoomName, vendorName);
        sut.addRoom(room);
        MeetingRoom room2 = new MeetingRoom(meetingRoomName, vendorName);
        room2.setAvailable(false);
        sut.addRoom(room2);

        ArrayList<MeetingRoom> expected = new ArrayList<>();
        expected.add(room);

        // act
        List<MeetingRoom> actual = sut.searchAvailable();

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void test_Reserve_a_Available_MeetingRooms(){
        // arrange
        MeetingRoomManager sut = new MeetingRoomManager();
        MeetingRoom room = new MeetingRoom(meetingRoomName, vendorName);
        sut.addRoom(room);

        // act
        boolean actual = sut.reserveMeetingRoom(meetingRoomName, vendorName);

        // assert
        Assert.assertEquals(true, actual);
        Assert.assertEquals(false, room.isAvailable);
    }

    @Test
    public void test_Reserve_a_Unavailable_MeetingRooms(){
        // arrange
        MeetingRoomManager sut = new MeetingRoomManager();
        MeetingRoom room = new MeetingRoom(meetingRoomName, vendorName);
        room.isAvailable = false;
        sut.addRoom(room);

        // act
        boolean actual = sut.reserveMeetingRoom(meetingRoomName, vendorName);

        // assert
        Assert.assertEquals(false, actual);
        Assert.assertEquals(false, room.isAvailable);
    }

    @Test
    public void test_Reserve_a_Available_MeetingRooms_When_There_Are_Two_Vendor_With_Same_MeetingRoomName(){
        // arrange
        MeetingRoomManager sut = new MeetingRoomManager();
        MeetingRoom room = new MeetingRoom(meetingRoomName, vendorName);
        MeetingRoom room2 = new MeetingRoom(meetingRoomName, "OtherVendorName");
        sut.addRoom(room2);
        sut.addRoom(room);

        // act
        boolean actual = sut.reserveMeetingRoom(meetingRoomName, vendorName);

        // assert
        Assert.assertEquals(true, actual);
        Assert.assertEquals(false, room.isAvailable);
        Assert.assertEquals(true, room2.isAvailable);
    }
}

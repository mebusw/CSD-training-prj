package example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomTest {
    @Test
    public void test_Search_All_Available_MeetingRooms(){
        // arrange
        MeetingRoomManager sut = new MeetingRoomManager();
        MeetingRoom room = new MeetingRoom();
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
        MeetingRoom room = new MeetingRoom();
        sut.addRoom(room);
        MeetingRoom room2 = new MeetingRoom();
        room2.setAvailable(false);
        sut.addRoom(room2);

        ArrayList<MeetingRoom> expected = new ArrayList<>();
        expected.add(room);

        // act
        List<MeetingRoom> actual = sut.searchAvailable();

        // assert
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}

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
}

package example.portal;

import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Thinkpad on 18-06-04.
 */
public class MeetingTest {

    private Meeting meeting;

    @Before
    public void setup() {
        this.meeting = new Meeting();
    }

    @Test
    public void testSearchStartDate() {
        RoomSearchEntity entity = new RoomSearchEntity();
        entity.setStartDate("2018-06-10");
        List<Room> rooms = meeting.search(entity);
        assertEquals(1, rooms.size());
    }

    @Test
    public void testSearchSize() {
        RoomSearchEntity entity = new RoomSearchEntity();
        entity.setSize(12);
        List<Room> rooms = meeting.search(entity);
        assertEquals(1, rooms.size());
    }

    @Test
    public void testSearchDuration() {
        RoomSearchEntity entity = new RoomSearchEntity();
        entity.setDuration(5);
        List<Room> rooms = meeting.search(entity);
        assertEquals(1, rooms.size());
    }

    @Test
    public void testSearchPrice() {
        RoomSearchEntity entity = new RoomSearchEntity();
        entity.setMaxPrice(1000);
        List<Room> rooms = meeting.search(entity);
        assertEquals(1, rooms.size());
    }

    /*@Test
    public void testBooking() {
        Room room = new Room();
        meeting.doBooking(room);
        assertEquals(Room.BookingStatusSuccess,room.getBookingStatus());
    }*/
    @Test
    public void testAddRoom() {
        User user = new User();
        Room room = new Room();
        room.setStartDate("2018-06-10");
        room.setSize(12);
        room.setDuration(5);
        room.setMaxPrice(1000);
        meeting.addRoom(user,room);
        List<Room> rooms = meeting.getAllRooms();
        assertEquals(1, rooms.size());
    }
}
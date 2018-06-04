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

}
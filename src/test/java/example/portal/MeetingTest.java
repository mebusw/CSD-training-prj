package example.portal;

import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Thinkpad on 18-06-04.
 */
public class MeetingTest {

    private Meeting meeting;
    private User adminUser;
    private User user;

    @Before
    public void setup() {
        this.meeting = new Meeting();
        this.user = new User();
        this.adminUser = new User();
        Room room = new Room();
        room.setStartDate("2018-06-10");
        room.setSize(12);
        room.setDuration(5);
        room.setPrice(900);
        this.meeting.addRoom(adminUser, room);
    }

    @After
    public void down() {
        this.meeting.cleanRooms();
    }

    @Test
    public void testSearchByExistedStartDate() {
        RoomSearchEntity entity = new RoomSearchEntity();
        String date = "2018-06-10";
        entity.setStartDate(date);

        List<Room> rooms = meeting.search(entity);

        assertEquals(1, rooms.size());
        assertEquals(date, rooms.get(0).getStartDate());
    }

    @Test
    public void testSearchByNotExistedStartDate() {
        RoomSearchEntity entity = new RoomSearchEntity();
        String date = "2018-06-09";
        entity.setStartDate(date);

        List<Room> rooms = meeting.search(entity);

        assertEquals(0, rooms.size());
    }

    @Test
    public void testSearchByExistedSize() {
        RoomSearchEntity entity = new RoomSearchEntity();
        int size = 12;
        entity.setSize(size);

        List<Room> rooms = meeting.search(entity);

        assertEquals(1, rooms.size());
        assertEquals(size, rooms.get(0).getSize());
    }

    @Test
    public void testSearchByExistedDuration() {
        RoomSearchEntity entity = new RoomSearchEntity();
        int duration = 5;
        entity.setDuration(duration);

        List<Room> rooms = meeting.search(entity);

        assertEquals(1, rooms.size());
        assertEquals(duration, rooms.get(0).getDuration());
    }

    @Test
    public void testSearchByExistedPrice() {
        RoomSearchEntity entity = new RoomSearchEntity();
        int maxPrice = 1000;
        entity.setMaxPrice(maxPrice);

        List<Room> rooms = meeting.search(entity);

        assertEquals(1, rooms.size());
        assertTrue(rooms.get(0).getPrice() <= maxPrice);
    }

    @Test
    public void testBooking() {
        RoomSearchEntity entity = new RoomSearchEntity();
        String date = "2018-06-10";
        entity.setStartDate(date);
        Room room = meeting.search(entity).get(0);

        Appointment appointment = meeting.doBooking(user, room);

        assertEquals(Room.BOOKING_STATUS_BOOKED,room.getBookingStatus());
        assertEquals("2018-06-04", appointment.getCreateDate());
        assertEquals(date, appointment.getRoom().getStartDate());
    }

    @Test
    public void testCancelBooking() {
        RoomSearchEntity entity = new RoomSearchEntity();
        String date = "2018-06-10";
        entity.setStartDate(date);
        Room room = meeting.search(entity).get(0);
        Appointment appointment = meeting.doBooking(user, room);

        meeting.cancelBooking(appointment);

        meeting.getAllAppointments();
        assertEquals(0,meeting.getAllAppointments().size());
        assertEquals(Room.BOOKING_STATUS_INIT, room.getBookingStatus());
    }

    @Test
    public void testAddRoom() {
        Room room = new Room();
        room.setStartDate("2018-06-10");
        room.setSize(12);
        room.setDuration(5);
        room.setPrice(1000);

        meeting.addRoom(adminUser,room);

        List<Room> rooms = meeting.getAllRooms();
        assertEquals(2, rooms.size());
    }

    @Test
    public void testGetAllAppointments() {
        Room room = new Room();

        Appointment appointment = meeting.doBooking(user,room);

        List<Appointment> appointments = meeting.getAllAppointments(user);
        assertEquals(1, appointments.size());
    }
}
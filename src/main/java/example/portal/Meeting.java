package example.portal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Thinkpad on 18-06-04.
 */
public class Meeting {

    private static List<Room> rooms = new ArrayList<>();

    public List<Room> search(RoomSearchEntity entity) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room());
        return rooms;
    }

    public void addRoom(User user, Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public Appointment doBooking(User user, Room room) {
        room.setBookStatus(Room.BOOKING_STATUS_BOOKED);
        Appointment appointment = new Appointment();
        appointment.setUser(user);
        appointment.setCreateDate("2018-06-04");
        appointment.setRoom(room);
        return  appointment;
    }
}

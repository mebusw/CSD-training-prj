package example.portal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Thinkpad on 18-06-04.
 */
public class Meeting {

    private static List<Room> rooms = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();


    public List<Room> search(RoomSearchEntity entity) {
        List<Room> _rooms = new ArrayList<>();
        for (Room room : rooms) {
            if ((entity.getStartDate() == null || entity.getStartDate().equals(room.getStartDate()))
                    && (entity.getSize() <= 0 || entity.getSize() == room.getSize())
                    && (entity.getDuration() <= 0 || entity.getDuration() == room.getDuration())
                    && (entity.getMaxPrice() <= 0 || entity.getMaxPrice() >= room.getPrice()))
                _rooms.add(room);
        }
        return _rooms;
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
        appointments.add(appointment);
        return appointment;
    }

    public List<Appointment> getAllAppointments(User user) {
        return appointments;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public void cancelBooking(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void cleanRooms() {
        rooms.clear();
    }
}

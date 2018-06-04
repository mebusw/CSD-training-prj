package example.entity;

import java.util.ArrayList;
import java.util.List;

public class HotelManager extends User {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public HotelManager() {
    }

    public HotelManager(String name, String email, String phone) {
        super(name, email, phone);
    }

    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom){
        meetingRooms.add(meetingRoom);
    }
}

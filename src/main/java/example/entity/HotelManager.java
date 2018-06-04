package example.entity;

import java.util.ArrayList;
import java.util.List;

public class HotelManager extends User {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

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

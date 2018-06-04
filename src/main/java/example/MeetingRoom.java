package example;

public class MeetingRoom {
    public boolean isAvailable = true;
    public String meetingRoomName;
    public String vendorName;

    public MeetingRoom(String meetingRoomName, String vendorName) {
        this.meetingRoomName = meetingRoomName;
        this.vendorName = vendorName;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}

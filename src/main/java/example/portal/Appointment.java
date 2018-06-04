package example.portal;

public class Appointment {

    private User user;

    private Room room;

    private String createDate;

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}

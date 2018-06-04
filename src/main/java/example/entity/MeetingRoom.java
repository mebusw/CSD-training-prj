package example.entity;

public class MeetingRoom {
    private String name;
    private String location;
    private String numberOfPeopleRongliang;
    private String price;
    private boolean isBooked;
    private String description;

    public MeetingRoom() {
    }

    public MeetingRoom(String name, String location, String numberOfPeopleRongliang, String price, boolean isBooked, String description) {
        this.name = name;
        this.location = location;
        this.numberOfPeopleRongliang = numberOfPeopleRongliang;
        this.price = price;
        this.isBooked = isBooked;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumberOfPeopleRongliang() {
        return numberOfPeopleRongliang;
    }

    public void setNumberOfPeopleRongliang(String numberOfPeopleRongliang) {
        this.numberOfPeopleRongliang = numberOfPeopleRongliang;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

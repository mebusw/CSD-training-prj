package example.entity;

public class MeetingRoom {
    private String name;
    private String location;
    private int capacity;
    private int price;
    private boolean isBooked;
    private String description;

    public MeetingRoom() {
    }

    public MeetingRoom(String name, String location, int capacity, int price, boolean isBooked, String description) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

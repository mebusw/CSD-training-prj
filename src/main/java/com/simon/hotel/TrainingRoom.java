package com.simon.hotel;

public class TrainingRoom {

    private String roomNo;

    private String hasWifi;

    private int capacity;

    private boolean used;

    private boolean opened;

    public TrainingRoom (String roomNo, String hasWifi, int capacity) {
        this.roomNo = roomNo;
        this.hasWifi = hasWifi;
        this.capacity = capacity;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(String hasWifi) {
        this.hasWifi = hasWifi;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

}

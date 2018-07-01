package com.simon.hotel;

import com.simon.institution.Course;

public class TrainingRoom {

    private String roomNo;

    private String hasWifi;

    private int capacity;

    private boolean used;

    private String customerName;

    private Course goingCourse;

    private boolean opened;

    public TrainingRoom (String roomNo, String hasWifi, int capacity) {
        this.roomNo = roomNo;
        this.hasWifi = hasWifi;
        this.capacity = capacity;
        this.used = false;
        this.opened = false;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Course getGoingCourse() {
        return goingCourse;
    }

    public void setGoingCourse(Course goingCourse) {
        this.goingCourse = goingCourse;
    }
}

package com.luke.hotel;

public class MeetingRoom {

    public static final int HAS_WIFI = 1;
    public static final int NO_WIFI = 0;

    private int id;

    private int hasWifi;

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    private String subscriber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(int hasWifi) {
        this.hasWifi = hasWifi;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public MeetingRoom(int i, int i1, int price) {
        this.id = id;
        this.hasWifi = i1;
        this.price = price;
    }
}

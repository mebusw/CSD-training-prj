package com.taylor.reservation.domain;

public class Room {

    private long id;
    private String roomNumber;
    private boolean hasWifi;
    private int outletNumber;
    private int seatsNumer;
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public int getOutletNumber() {
        return outletNumber;
    }

    public void setOutletNumber(int outletNumber) {
        this.outletNumber = outletNumber;
    }

    public int getSeatsNumer() {
        return seatsNumer;
    }

    public void setSeatsNumer(int seatsNumer) {
        this.seatsNumer = seatsNumer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", hasWifi=" + hasWifi +
                ", outletNumber=" + outletNumber +
                ", seatsNumer=" + seatsNumer +
                ", price=" + price +
                '}';
    }
}

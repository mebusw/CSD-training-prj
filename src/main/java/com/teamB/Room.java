package com.teamB;

public class Room {
    public String getName() {
        return name;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getCapiblity() {
        return capiblity;
    }

    private String name;
    private String hotelName;
    private int capiblity;

    public void setName(String name) {
        this.name = name;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setCapiblity(int capiblity) {
        this.capiblity = capiblity;
    }


}

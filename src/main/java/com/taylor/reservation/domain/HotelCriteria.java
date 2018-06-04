package com.taylor.reservation.domain;

public class HotelCriteria {

    private Boolean roomHasWifi;
    private Integer pageIndex;
    private int outletNum;
    private int seatsNumberLeft;
    private int priceLeft;
    private int priceRight;


    public static HotelCriteria create() {
        return new HotelCriteria();
    }

    public HotelCriteria roomHasWifi(boolean roomHasWifi) {
        this.roomHasWifi = roomHasWifi;
        return this;
    }

    public HotelCriteria pageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public HotelCriteria roomOutletNumGt(int p) {
        this.outletNum = p;
        return this;
    }

    public HotelCriteria roomSeatsNumGt(int p) {
        this.seatsNumberLeft = p;
        return this;

    }

    public HotelCriteria roomPriceGt(int p) {
        this.priceLeft = p ;
        return this;
    }

    public HotelCriteria roomPriceLt(int p) {
        this.priceRight = p ;
        return this;
    }
}

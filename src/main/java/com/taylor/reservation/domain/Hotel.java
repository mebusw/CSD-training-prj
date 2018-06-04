package com.taylor.reservation.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hotel {

    private Long id;
    private String name;
    private String addr;
    private String phone;
    private List<Room> rooms;

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}

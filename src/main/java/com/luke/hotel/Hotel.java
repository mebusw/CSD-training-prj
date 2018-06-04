package com.luke.hotel;

import com.luke.trainingagency.TrainingAgency;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public int emptyRoom = 10;

    public Hotel(){
        rooms = new ArrayList<>();
    }

    public List<ConferenceRoom> rooms;

    public Boolean booking(TrainingAgency hotel) {
        return true;
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {

    }
}

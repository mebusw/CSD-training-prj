package com.luke.hotel;

import com.luke.trainingagency.TrainingAgency;

import java.util.*;

public class Hotel {
    public int emptyRoom = 10;

    public Hotel(){
        rooms = new HashMap<Integer, MeetingRoom>();
    }

    public Map<Integer, MeetingRoom> rooms;

    public Boolean booking(TrainingAgency subscriber, int wifiType) {

        Set<Integer> roomList = (Set<Integer>)rooms.keySet();

//        Set<> roomSet = rooms.values();
        for(Integer roomid : roomList){
            MeetingRoom room = rooms.get(roomid);
            if(room.getHasWifi()==wifiType && (null == room.getSubscriber() || "".equals(room.getSubscriber()))){
                room.setSubscriber(subscriber.getName());
                return true;
            }
        }

        return false;
    }

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        rooms.put(meetingRoom.getId(),meetingRoom);
    }

    public void release(int i) {
        Set<Integer> roomList = rooms.keySet();

        MeetingRoom room = rooms.get(i);
        if (null != room) {
            room.setSubscriber("");
        }
    }
}

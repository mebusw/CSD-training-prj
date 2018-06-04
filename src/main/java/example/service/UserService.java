package example.service;

import example.entity.HotelManager;
import example.entity.MeetingRoom;
import example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> userList = new ArrayList<>();

    public void add(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<HotelManager> getHotelManagerList() {

        List<HotelManager> hotelManagers = new ArrayList<>();
        for (User u : userList) {
            if (u instanceof HotelManager) {
                hotelManagers.add((HotelManager) u);
            }
        }

        return hotelManagers;
    }

    public List<MeetingRoom> getMeetingRooms() {

        List<HotelManager> hotelManagers = getHotelManagerList();

        List<MeetingRoom> meetingRooms = new ArrayList<>();
        for(HotelManager hotelManager : hotelManagers) {
            meetingRooms.addAll(hotelManager.getMeetingRooms());
        }

        return meetingRooms;
    }
}

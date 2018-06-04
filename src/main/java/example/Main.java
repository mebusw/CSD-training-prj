package example;

import com.google.gson.Gson;
import example.entity.HotelManager;
import example.entity.MeetingRoom;
import example.entity.User;
import example.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static UserService userService = new UserService();
    private static HotelManager hotelManager = new HotelManager();
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("addUser")) {
                    addUser(line);
                } else if (line.contains("addMeetingRoom")){
                    addMeetingRoom(line);
                } else {
                    System.out.println(line);

                }
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private static void addMeetingRoom(String line) {
        String[] info = line.split(",");

        hotelManager.addMeetingRoom(new MeetingRoom(info[1], info[2], Integer.valueOf(info[3]), Integer.valueOf(info[4]),false,info[5]));
        System.out.println((new Gson()).toJson(hotelManager.getMeetingRooms()));
    }

    private static void addUser(String line) {
        String[] info = line.split(",");
        userService.add(new User(info[1], info[2], info[3]));
        System.out.println((new Gson()).toJson(userService.getUserList()));
    }
}
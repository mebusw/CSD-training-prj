package example;

import java.io.*;

public class One {

    public static final MeetingRoomManager meetingRoomManager = new MeetingRoomManager();


    public static void main(String[] args) throws IOException {
        if (args == null) {
            System.out.println("Args should be not null.");
            return;
        }

        String user = "user";
        String vendor = "vendor";

        if (args[0].equals(user)) {
            if (args.length == 1) {
                System.out.println("user need other args: search or reserve.");
                return;
            }

            searchAvailableMeetingRooms();
            return;
        }
        if (args[0].equals(vendor)) {
            if (args.length == 1) {
                System.out.println("vendor need other args: add, remove or list.");
                return;
            }

            meetingRoomManager.addRoom(new MeetingRoom(args[3], args[1]));
            System.out.println(args[1] + " " + args[2] + " " + args[3]);
        }
    }

    private static void searchAvailableMeetingRooms() {
        if (meetingRoomManager.searchAvailable().isEmpty()) {
            System.out.println( "Currently, there is not available meeting rooms.");
        }

        for (MeetingRoom availableRoom : meetingRoomManager.searchAvailable()) {
            System.out.println(availableRoom.meetingRoomName + " from " + availableRoom.vendorName);
        }
    }
}
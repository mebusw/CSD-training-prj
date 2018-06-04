package com.teamB;

import java.io.*;

public class Main {

    public static void main (String[] args)  throws IOException {


        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("please input meeting type :");
        String meetingType = in.readLine();

        System.out.println("please input count of attendee :");
        String count = in.readLine();

        System.out.println("==================================================================");
        System.out.println("please input count of attendee :" +  count);
        System.out.println("please input  meeting type  :" +  meetingType);

        //RoomSearcher searcher = new RoomSearcher()

        RoomManager rm = new RoomManager();



        System.out.println("----------mian-------------");
    }
}
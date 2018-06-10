package com.taylor.reservation;

import com.taylor.reservation.domain.HotelCriteria;
import com.taylor.reservation.domain.Reservation;
import com.taylor.reservation.service.CustomerService;
import com.taylor.reservation.service.HotelService;
import com.taylor.reservation.service.ReservationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {


    static CustomerService customerService = new CustomerService();
    static HotelService hotelService = new HotelService();

    public static void main (String[] args)  throws IOException {
        if (args[0].equals("meetingroom")) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(System.in));
                String line;
                while ((line = in.readLine()) != null) {
                    if(line.equals("queryrooms")) {
                        System.out.println(hotelService.search(HotelCriteria.create()));
                    }
                    if(line.startsWith("reserve ")) {
                        String[] reserveInfo = line.split(" ");
                        Reservation reservation = new Reservation();
                        reservation.setRoomId(Long.valueOf(reserveInfo[1]));
                        System.out.println(customerService.reserve(reservation));
                    }
                }
            }
            catch (IOException e) {
                throw e;
            }
            finally {
                if (in != null) {
                    in.close();
                }
            }
        } else {
            for (String s: args) {
                System.out.println(s);
            }
        }
    }

}

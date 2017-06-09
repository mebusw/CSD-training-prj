package Tennis;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by CHEUNBE2 on 6/7/2017.
 */
public class TennisTest {
    private Booking booking;

    @Test
    public void reserveSuccessTest(){
        Slot reserveSlot = new Slot("1", "HKHKG", "201706071000");

        Account account=new Account("user","password");
        assertEquals("Success", Tennis.reserve(account,reserveSlot));
    }

    @Test
    public void reserveFailTest(){
        Slot reserveSlot = new Slot("1", "HKHKG", "201706071000");
        Account account=new Account("user","password");
        reserveSlot.setAvailablity(false);
        assertEquals("Fail", Tennis.reserve(account,reserveSlot));

    }

    @Test
    public void reserveFailBookingTest(){
        Slot reserveSlot = new Slot("1", "HKHKG", "201706071000");
        Account account=new Account("user","password");
        reserveSlot.setAvailablity(false);
        Tennis.reserve(account,reserveSlot);
        int booking_size = account.getReservedBooking(account).size();
        assertEquals(1, booking_size);
    }

    @Test
    public void CheckBookingInAcc(){
        Account account=new Account("user","password");
        Slot reserveSlot = new Slot("1", "HKHKG", "201706071000");
        Tennis.reserve(account,reserveSlot);
        ArrayList<Booking> arr_booking= account.getReservedBooking(account);
        assertEquals(1,arr_booking.size());
    }


//
//    @Test
//    public void paymentTest(){
//        assertEquals("Success", Tennis.collectPayment());
//    }
//
//    @Test
//    public void notifyTest(){
//        assertEquals("Success", Tennis.notify(Booking));
//    }

    @Test
    public void publish(){
        Slot testSlot = new Slot("1", "HKHKG", "201706071000");
        assertEquals("Success", Tennis.publish(testSlot));
    }



}
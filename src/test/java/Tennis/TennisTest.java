package Tennis;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by CHEUNBE2 on 6/7/2017.
 */
public class TennisTest {
    private Booking booking;

    @Test
    public void reserveSuccessTest(){
        Slot reserveSlot = new Slot("1", "HKHKG", "201706071000");

        assertEquals("Success", Tennis.reserve(reserveSlot));
    }

    @Test
    public void reserveFailTest(){
        Slot reserveSlot = new Slot("1", "HKHKG", "201706071000");
        reserveSlot.setAvailablity(false);
        assertEquals("Fail", Tennis.reserve(reserveSlot));
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
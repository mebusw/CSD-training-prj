package Tennis;

/**
 * Created by CHEUNBE2 on 6/7/2017.
 */
public class Tennis {
    public static String publish(Slot testSlot) {
        return ("Success");
    }

    public static String reserve(Account acc, Slot reserveSlot) {

        if(reserveSlot.getAvailablity()){
            reserveSlot.setAvailablity(false);
            Booking confirmed_booking = new Booking();
            confirmed_booking.setStatus("Success");
            confirmed_booking.setSlot(reserveSlot);
            acc.booking.add(confirmed_booking);
            return confirmed_booking.getStatus();
        }

        else
        {
            Booking confirmed_booking = new Booking();
            confirmed_booking.setStatus("Fail");
            confirmed_booking.setSlot(reserveSlot);
            acc.booking.add(confirmed_booking);
            return confirmed_booking.getStatus();
        }
    }
}

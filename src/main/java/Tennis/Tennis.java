package Tennis;

import java.util.ArrayList;

/**
 * Created by CHEUNBE2 on 6/7/2017.
 */
public class Tennis {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private Slot[] slots;
    private Booking[] bookings;

    public static String publish(Slot testSlot) {
        return ("Success");
    }


    public static String reserve(Account acc, Slot reserveSlot) {

        Booking confirmed_booking = new Booking();

        if (reserveSlot.getAvailablity()) {
            reserveSlot.setAvailablity(false);
            confirmed_booking.setStatus("Success");
        } else {
            confirmed_booking.setStatus("Fail");
        }

        confirmed_booking.setSlot(reserveSlot);
        acc.booking.add(confirmed_booking);
        return confirmed_booking.getStatus();
    }

    public Account login(String username, String password) {
        for (int i =0 ; i < accounts.size(); i++){
            if (accounts.get(i).auth(username, password)){
                return accounts.get(i);
            }
        }
        return new Account("", "");
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}

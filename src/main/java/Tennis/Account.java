package Tennis;

import java.util.ArrayList;

public class Account {
    String username;
    String userpassword;
    ArrayList<Booking> booking;
     protected Account(String username,String password){
         this.userpassword=password;
         this.username=username;
         this.booking=new ArrayList<Booking>();
     }

    public ArrayList<Booking> getReservedBooking(Account account) {
         return this.booking;
    }
}

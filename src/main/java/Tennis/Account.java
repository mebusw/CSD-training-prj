package Tennis;

import java.util.ArrayList;

public class Account {
    String username;
    String userpassword;
    String userrole;


    ArrayList<Booking> booking;
     protected Account(String username,String password){
         this.userpassword = password;
         this.username = username;
         this.userrole = "member";
         this.booking = new ArrayList<Booking>();
     }

    public ArrayList<Booking> getReservedBooking(Account account) {
         return this.booking;
    }


    public String getRole() {
         return this.userrole;
    }

    public boolean auth(String username, String password) {
        if (this.username == username && this.userpassword == password) return true; else return false;
     }
}

package Tennis;

/**
 * Created by CHEUNBE2 on 6/7/2017.
 */
public class Tennis {
    public static String publish(Slot testSlot) {
        return ("Success");
    }

    public static String reserve(Slot reserveSlot) {
        if(reserveSlot.getAvailablity())
            return "Success";
        else
            return "Fail";
    }
}

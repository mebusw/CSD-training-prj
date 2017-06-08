package Tennis;

/**
 * Created by CHEUNBE2 on 6/7/2017.
 */
public class Slot {
    private String fee;
    private String location;
    private String time;
    private boolean isAvailable;

    public Slot(String fee, String location, String time){
        //Each Slot has 1 hour
        this.fee = fee;
        this.location= location;
        this.time= time;
        this.isAvailable=true;
    }
    public void setAvailablity(boolean setValue){
        this.isAvailable=setValue;
    }
    public boolean getAvailablity(){
        return this.isAvailable;
    }

}

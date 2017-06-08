package Tennis;

public class Booking {
    private Slot slot;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public void setSlot(Slot s) {
        this.slot = s;
    }

    public Slot getSlot(){
        return this.slot;
    }

}

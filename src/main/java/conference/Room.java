package conference;

public class Room implements Comparable {
    public Room() {
    }

    public Room(String roomId, String addr, double price,String status) {
        this.roomId = roomId;
        this.addr = addr;
        this.price = price;
        this.status = status;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return this.roomId + "-"+ this.addr + "-" +this.price+ "-" +this.getStatus();
    }

    private String roomId;
    private String addr;
    private double price;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private String status;

    @Override
    public int compareTo(Object o) {
        Room room2 = (Room)o;
        if (this.getPrice()>room2.getPrice()){
            return 1;
        }else if(this.getPrice()<room2.getPrice()) {
            return -1;
        }
        return 0;
    }
}

package conference;

public class RoomOrder {
    public final static int ORDER_STATUS_INITI = 0;
    public final static int ORDER_STATUS_SUCCESS = 1;
    public final static int ORDER_STATUS_FAIL = 99;
    private String roomId;
    private String startDate;
    private String endDate;
    private int orderStatus;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}

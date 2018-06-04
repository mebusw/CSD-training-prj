package example.service.dto;

public class RoomCondition {

    private int minPrice;
    private int maxPrice;
    private int minCapacity;
    private int maxCapacity;

    public RoomCondition() {
    }

    public RoomCondition(int minPrice, int maxPrice, int minCapacity, int maxCapacity) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}

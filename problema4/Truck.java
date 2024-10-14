package problema4;

public class Truck {
    private int capacity;
    private String startPoint;
    private String endPoint;

    public Truck(int capacity, String startPoint, String endPoint) {
        this.capacity = capacity;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }
}

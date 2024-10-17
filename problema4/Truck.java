package problema4;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private final int capacity;
    private int currentCapacity;
    private String startPoint;
    private List<String> middlePoints;
    private String endPoint;

    public Truck(int capacity, String startPoint, String endPoint) {
        this.capacity = capacity;
        this.startPoint = startPoint;
        this.middlePoints = new ArrayList<>();
        this.endPoint = endPoint;
        this.currentCapacity = 0;
    }

    public Truck(int capacity, String startPoint, List<String> middlePoints, String endPoint) {
        this.capacity = capacity;
        this.startPoint = startPoint;
        this.middlePoints = middlePoints;
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

    public List<String> getMiddlePoints() {
        return middlePoints;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int addBooks(int books) {
        this.currentCapacity += books;
        return this.currentCapacity;
    }

    public int removeBooks(int books) {
        this.currentCapacity -= books;
        return this.currentCapacity;
    }
}

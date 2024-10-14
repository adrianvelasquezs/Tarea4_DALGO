package problema4;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private int capacity;
    private String startPoint;
    private List<String> middlePoints;
    private String endPoint;

    public Truck(int capacity, String startPoint, String endPoint) {
        this.capacity = capacity;
        this.startPoint = startPoint;
        this.middlePoints = new ArrayList<>();
        this.endPoint = endPoint;
    }

    public Truck(int capacity, String startPoint, ArrayList<String> middlePoints, String endPoint) {
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
}

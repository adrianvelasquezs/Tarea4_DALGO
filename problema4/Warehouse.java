package problema4;

public class Warehouse {
    private int capacity;
    private int currentCapacity;

    public Warehouse(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public int getCapacity() {
        return capacity;
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

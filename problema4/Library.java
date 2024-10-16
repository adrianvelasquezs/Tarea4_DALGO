package problema4;

public class Library {
    private int currentCapacity;

    public Library(){
        this.currentCapacity = 0;
    }

    public int getCapacity() {
        return currentCapacity;
    }

    public int addBooks( int books ){
        this.currentCapacity += books;
        return this.currentCapacity;
    }

    public int removeBooks( int books ){
        this.currentCapacity -= books;
        return this.currentCapacity;
    }
}

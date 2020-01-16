package step1;

public class FixedLengthIntStack {
    private final int[] store;
    private int current;

    public FixedLengthIntStack(int capacity){
        this.store = new int[capacity];
    }

    public int getSize() {
        return 0;
    }

    public int getCapacity() {
        return 0;
    }

    public int pop() {
        return store[current];
    }

    public void push(int item) {
        store[current] = item;
    }
}

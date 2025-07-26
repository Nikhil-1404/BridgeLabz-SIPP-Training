public class CircularBuffer {
    private int[] buffer;
    private int head = 0; // Points to the oldest element
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Add a new element to the buffer
    public void add(int value) {
        int tail = (head + size) % capacity;
        buffer[tail] = value;

        if (size == capacity) {
            // Overwrite: move head forward
            head = (head + 1) % capacity;
        } else {
            size++;
        }
    }

    // Get all elements in correct order
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.display(); // Output: [1, 2, 3]

        cb.add(4); // Overwrites 1
        cb.display(); // Output: [2, 3, 4]

        cb.add(5); // Overwrites 2
        cb.display(); // Output: [3, 4, 5]
    }
}

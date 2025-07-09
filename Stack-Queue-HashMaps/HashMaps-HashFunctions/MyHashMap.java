import java.util.*;

class MyHashMap<K, V> {
    // Node class for linked list
    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private LinkedList<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        for (Node node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        buckets[index].add(new Node(key, value));
    }

    // Get value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        for (Node node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        Iterator<Node> it = buckets[index].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.key.equals(key)) {
                it.remove();
                return;
            }
        }
    }

    // Utility function to display the hash map
    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Node node : buckets[i]) {
                System.out.print("[" + node.key + "=" + node.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        System.out.println("Value for key 'banana': " + map.get("banana"));

        map.remove("banana");
        System.out.println("After removing 'banana':");
        map.display();
    }
}

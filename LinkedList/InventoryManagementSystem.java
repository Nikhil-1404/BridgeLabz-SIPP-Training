import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    Item head;

    // Add at beginning
    void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    // Add at specific position (1-based index)
    void addAtPosition(int position, String name, int id, int quantity, double price) {
        if (position == 1) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
        } else {
            newItem.next = current.next;
            current.next = newItem;
        }
    }

    // Remove by Item ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        Item current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item ID not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item removed.");
        }
    }

    // Update quantity by Item ID
    void updateQuantity(int id, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.id == id) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by Item ID
    void searchById(int id) {
        Item current = head;
        while (current != null) {
            if (current.id == id) {
                System.out.println("Item Found: Name: " + current.name + ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by Item Name
    void searchByName(String name) {
        Item current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("Item Found: ID: " + current.id + ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item Name not found.");
    }

    // Calculate total inventory value
    void calculateTotalValue() {
        double total = 0;
        Item current = head;
        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    // Display all items
    void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item current = head;
        while (current != null) {
            System.out.println("Name: " + current.name + ", ID: " + current.id + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    // Sort by Item Name (Bubble Sort)
    void sortByName(boolean ascending) {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            while (current.next != null) {
                if ((ascending && current.name.compareTo(current.next.name) > 0) ||
                    (!ascending && current.name.compareTo(current.next.name) < 0)) {
                    // Swap values
                    String tempName = current.name;
                    int tempId = current.id;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;

                    current.name = current.next.name;
                    current.id = current.next.id;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;

                    current.next.name = tempName;
                    current.next.id = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by name.");
    }

    // Sort by Price (Bubble Sort)
    void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            while (current.next != null) {
                if ((ascending && current.price > current.next.price) ||
                    (!ascending && current.price < current.next.price)) {
                    // Swap values
                    String tempName = current.name;
                    int tempId = current.id;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;

                    current.name = current.next.name;
                    current.id = current.next.id;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;

                    current.next.name = tempName;
                    current.next.id = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Inventory sorted by price.");
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();
        int choice;

        do {
            System.out.println("\n*** Inventory Management System ***");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Remove by Item ID");
            System.out.println("5. Update Quantity by Item ID");
            System.out.println("6. Search by Item ID");
            System.out.println("7. Search by Item Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Sort by Item Name");
            System.out.println("11. Sort by Price");
            System.out.println("12. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    inventory.addAtBeginning(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    inventory.addAtEnd(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    inventory.addAtPosition(pos, sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    inventory.removeById(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new Quantity: ");
                    inventory.updateQuantity(id, sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Item ID to search: ");
                    inventory.searchById(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter Item Name to search: ");
                    inventory.searchByName(sc.next());
                    break;
                case 8:
                    inventory.displayAll();
                    break;
                case 9:
                    inventory.calculateTotalValue();
                    break;
                case 10:
                    System.out.print("Sort ascending? (true/false): ");
                    inventory.sortByName(sc.nextBoolean());
                    break;
                case 11:
                    System.out.print("Sort ascending? (true/false): ");
                    inventory.sortByPrice(sc.nextBoolean());
                    break;
                case 12:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 12);

        sc.close();
    }
}

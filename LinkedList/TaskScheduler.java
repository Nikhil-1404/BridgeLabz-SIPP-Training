import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    Task head = null;
    Task tail = null;
    Task current = null;

    // Add at beginning
    void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            current = head;
        } else {
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
    }

    // Add at end
    void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            current = head;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    // Add at specific position (1-based index)
    void addAtPosition(int position, int id, String name, int priority, String dueDate) {
        if (position == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task currentTask = head;
        for (int i = 1; i < position - 1; i++) {
            currentTask = currentTask.next;
            if (currentTask == head) {
                System.out.println("Position out of bounds.");
                return;
            }
        }
        newTask.next = currentTask.next;
        currentTask.next = newTask;
        if (currentTask == tail) {
            tail = newTask;
        }
    }

    // Remove by Task ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Task currentTask = head;
        Task prevTask = tail;
        do {
            if (currentTask.id == id) {
                if (currentTask == head) {
                    head = head.next;
                    tail.next = head;
                    if (current == currentTask) current = head;
                } else if (currentTask == tail) {
                    tail = prevTask;
                    tail.next = head;
                    if (current == currentTask) current = head;
                } else {
                    prevTask.next = currentTask.next;
                    if (current == currentTask) current = currentTask.next;
                }
                System.out.println("Task deleted.");
                if (head == tail && head.id == id) { // only node deleted
                    head = tail = current = null;
                }
                return;
            }
            prevTask = currentTask;
            currentTask = currentTask.next;
        } while (currentTask != head);
        System.out.println("Task ID not found.");
    }

    // View current task and move to next
    void viewCurrentAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Current Task -> ID: " + current.id + ", Name: " + current.name + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
        current = current.next;
    }

    // Display all tasks
    void displayAll() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Task currentTask = head;
        do {
            System.out.println("ID: " + currentTask.id + ", Name: " + currentTask.name + ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
            currentTask = currentTask.next;
        } while (currentTask != head);
    }

    // Search by Priority
    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        boolean found = false;
        Task currentTask = head;
        do {
            if (currentTask.priority == priority) {
                System.out.println("ID: " + currentTask.id + ", Name: " + currentTask.name + ", Due Date: " + currentTask.dueDate);
                found = true;
            }
            currentTask = currentTask.next;
        } while (currentTask != head);
        if (!found) {
            System.out.println("No tasks found with this priority.");
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();
        int choice;

        do {
            System.out.println("\n*** Task Scheduler Menu ***");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Remove by Task ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    scheduler.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    scheduler.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    scheduler.addAtPosition(pos, sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    scheduler.removeById(sc.nextInt());
                    break;
                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;
                case 6:
                    scheduler.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Priority to search: ");
                    scheduler.searchByPriority(sc.nextInt());
                    break;
                case 8:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        sc.close();
    }
}

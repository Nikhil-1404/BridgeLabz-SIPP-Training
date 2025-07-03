import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    TextState head;
    TextState tail;
    TextState current;
    int size = 0;
    final int MAX_HISTORY = 10;

    // Add new text state at end
    void addState(String content) {
        TextState newState = new TextState(content);

        if (current != null && current.next != null) {
            // Clear redo history
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }
        current = tail;
        size++;

        // Limit history to MAX_HISTORY
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("New state added.");
    }

    // Undo functionality
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("Cannot undo further.");
        }
    }

    // Redo functionality
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("Cannot redo further.");
        }
    }

    // Display current state
    void displayCurrent() {
        if (current != null) {
            System.out.println("Current Text State: \"" + current.content + "\"");
        } else {
            System.out.println("No content available.");
        }
    }
}

public class TextEditorUndoRedo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n*** Text Editor Undo/Redo System ***");
            System.out.println("1. Type Text / Perform Action (Add State)");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text content: ");
                    String content = sc.nextLine();
                    editor.addState(content);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head;

    // Add a new user
    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Find user by ID
    User findUserById(int id) {
        User current = head;
        while (current != null) {
            if (current.userId == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search user by name
    void searchByName(String name) {
        User current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("User ID: " + current.userId + ", Age: " + current.age);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    // Add friend connection between two users
    void addFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friends.contains(id2)) {
            user1.friends.add(id2);
        }
        if (!user2.friends.contains(id1)) {
            user2.friends.add(id1);
        }
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove friend connection between two users
    void removeFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friends.remove(Integer.valueOf(id2));
        user2.friends.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a specific user
    void displayFriends(int id) {
        User user = findUserById(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friends) {
            User friend = findUserById(friendId);
            if (friend != null) {
                System.out.println("Friend ID: " + friend.userId + ", Name: " + friend.name);
            }
        }
    }

    // Find mutual friends between two users
    void mutualFriends(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        boolean found = false;
        for (int fid1 : user1.friends) {
            if (user2.friends.contains(fid1)) {
                User mutual = findUserById(fid1);
                if (mutual != null) {
                    System.out.println("User ID: " + mutual.userId + ", Name: " + mutual.name);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No mutual friends.");
        }
    }

    // Count number of friends for each user
    void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println("User: " + current.name + ", Number of friends: " + current.friends.size());
            current = current.next;
        }
    }
}

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        // Adding sample users
        sm.addUser(1, "Alice", 21);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 23);
        sm.addUser(4, "David", 20);

        int choice;
        do {
            System.out.println("\n*** Social Media Friend Connection System ***");
            System.out.println("1. Add Friend Connection");
            System.out.println("2. Remove Friend Connection");
            System.out.println("3. Find Mutual Friends");
            System.out.println("4. Display Friends of a User");
            System.out.println("5. Search User by Name");
            System.out.println("6. Count Friends of All Users");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter two User IDs to connect: ");
                    sm.addFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter two User IDs to disconnect: ");
                    sm.removeFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter two User IDs to find mutual friends: ");
                    sm.mutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID to display friends: ");
                    sm.displayFriends(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    sm.searchByName(sc.nextLine());
                    break;
                case 6:
                    sm.countFriends();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }
}

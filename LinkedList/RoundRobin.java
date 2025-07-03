import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;
    Process tail = null;

    // Add process at end
    void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    // Remove process by pid
    void removeProcess(int pid) {
        if (head == null) return;
        Process current = head, prev = tail;
        do {
            if (current.pid == pid) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                if (head == tail && head.pid == pid) { // last node
                    head = tail = null;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate round robin scheduling
    void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        int time = 0;
        Process current = head;
        do {
            if (current.remainingTime > 0) {
                int executedTime = Math.min(timeQuantum, current.remainingTime);
                time += executedTime;
                current.remainingTime -= executedTime;
                current.turnaroundTime = time;

                System.out.println("Process " + current.pid + " executed for " + executedTime + " units. Remaining: " + current.remainingTime);
            }
            current = current.next;
        } while (!allCompleted());
        
        // Calculate waiting time and display average times
        int totalWT = 0, totalTAT = 0, count = 0;
        current = head;
        do {
            current.waitingTime = current.turnaroundTime - current.burstTime;
            totalWT += current.waitingTime;
            totalTAT += current.turnaroundTime;
            count++;
            System.out.println("PID: " + current.pid + ", Waiting Time: " + current.waitingTime + ", Turnaround Time: " + current.turnaroundTime);
            current = current.next;
        } while (current != head);

        System.out.println("Average Waiting Time: " + (double)totalWT / count);
        System.out.println("Average Turnaround Time: " + (double)totalTAT / count);
    }

    boolean allCompleted() {
        if (head == null) return true;
        Process current = head;
        do {
            if (current.remainingTime > 0) return false;
            current = current.next;
        } while (current != head);
        return true;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 5, 1);
        scheduler.addProcess(2, 3, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);

        System.out.print("Enter time quantum: ");
        int tq = sc.nextInt();

        scheduler.simulate(tq);
    }
}

import java.util.*;

class WithdrawalRequest {
    int accountNumber;
    double amount;

    WithdrawalRequest(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {
    private HashMap<Integer, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Create new account
    public void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit amount
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Add withdrawal request to queue
    public void requestWithdrawal(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Process all withdrawals
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            double balance = accounts.get(req.accountNumber);
            if (balance >= req.amount) {
                accounts.put(req.accountNumber, balance - req.amount);
                System.out.println("Withdrawal of ₹" + req.amount + " from Account " + req.accountNumber + " successful.");
            } else {
                System.out.println("Insufficient balance for Account " + req.accountNumber + ". Request denied.");
            }
        }
    }

    // Display all accounts sorted by balance using TreeMap
    public void displayAccountsByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        TreeMap<Double, List<Integer>> sorted = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sorted.putIfAbsent(entry.getValue(), new ArrayList<>());
            sorted.get(entry.getValue()).add(entry.getKey());
        }

        for (Map.Entry<Double, List<Integer>> entry : sorted.entrySet()) {
            double balance = entry.getKey();
            for (int accNum : entry.getValue()) {
                System.out.println("Account: " + accNum + ", Balance: ₹" + balance);
            }
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        System.out.println("\nAll Accounts:");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + ", Balance: ₹" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Add accounts
        bank.addAccount(101, 5000);
        bank.addAccount(102, 8000);
        bank.addAccount(103, 3000);

        // Deposit
        bank.deposit(101, 1000);  // 6000

        // Withdrawal Requests
        bank.requestWithdrawal(101, 2000);
        bank.requestWithdrawal(102, 9000); // Insufficient
        bank.requestWithdrawal(103, 2500);

        // Display before processing
        bank.displayAllAccounts();

        // Process withdrawals
        bank.processWithdrawals();

        // Display after processing
        bank.displayAllAccounts();

        // Sorted display
        bank.displayAccountsByBalance();
    }
}

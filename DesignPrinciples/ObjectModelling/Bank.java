import java.util.*;

// Class representing a Bank
class Bank {
    private String name;
    private List<BankAccount> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Method to open a new account for a customer
    public BankAccount openAccount(Customer customer, double initialBalance) {
        BankAccount account = new BankAccount(this, customer, initialBalance);
        accounts.add(account);
        customer.addAccount(account); // Association established
        System.out.println("Account opened for " + customer.getName() + " at " + name);
        return account;
    }

    public String getName() {
        return name;
    }

    // Display all accounts in this bank
    public void displayAllAccounts() {
        System.out.println("\nAccounts in " + name + ":");
        for (BankAccount acc : accounts) {
            acc.displayAccount();
        }
    }
}

// Class representing a Customer
class Customer {
    private String name;
    private List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to view all balances for this customer
    public void viewBalance() {
        System.out.println("\nBalance details for " + name + ":");
        for (BankAccount acc : accounts) {
            acc.displayAccount();
        }
    }
}

// Class representing a BankAccount (links Bank and Customer)
class BankAccount {
    private static int idCounter = 1000;
    private int accountNumber;
    private Bank bank;
    private Customer customer;
    private double balance;

    public BankAccount(Bank bank, Customer customer, double initialBalance) {
        this.accountNumber = idCounter++;
        this.bank = bank;
        this.customer = customer;
        this.balance = initialBalance;
    }

    // Display account details
    public void displayAccount() {
        System.out.println("Account No: " + accountNumber +
            ", Bank: " + bank.getName() +
            ", Customer: " + customer.getName() +
            ", Balance: ₹" + balance);
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Optional: Deposit and Withdraw methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited into Account No: " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn from Account No: " + accountNumber);
        } else {
            System.out.println("Insufficient balance in Account No: " + accountNumber);
        }
    }
}

// Main class to demonstrate the association
 class Main {
    public static void main(String[] args) {
        // Create banks
        Bank hdfc = new Bank("HDFC Bank");
        Bank sbi = new Bank("SBI");

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts
        BankAccount acc1 = hdfc.openAccount(alice, 5000);
        BankAccount acc2 = sbi.openAccount(alice, 8000);
        BankAccount acc3 = hdfc.openAccount(bob, 12000);

        // Optional transactions
        acc1.deposit(1500);
        acc3.withdraw(3000);

        // View balances
        alice.viewBalance();
        bob.viewBalance();

        // View accounts in banks
        hdfc.displayAllAccounts();
        sbi.displayAllAccounts();
    }
}

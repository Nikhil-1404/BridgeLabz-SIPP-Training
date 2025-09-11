// Interface Loanable with required methods
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract class BankAccount with encapsulation
abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setters for updating balance internally
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display method
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("Loan Eligibility: " + calculateLoanEligibility());
        System.out.println("---------------------------------------");
    }
}

// SavingsAccount with specific interest calculation
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest for savings
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account: Applied for a loan of " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 10; // Eligibility up to 10 times balance
    }
}

// CurrentAccount with specific interest calculation
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest for current accounts
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account: Applied for a loan of " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5; // Eligibility up to 5 times balance
    }
}

// Main class to test
public class BankingSystem {
    public static void main(String[] args) {
        // Creating accounts using polymorphism
        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount("SAV123", "Alice", 50000);
        accounts[1] = new CurrentAccount("CUR456", "Bob", 80000);

        // Process accounts dynamically
        for (BankAccount acc : accounts) {
            acc.deposit(10000);
            acc.withdraw(5000);
            acc.applyForLoan(200000);
            acc.displayAccountDetails();
        }
    }
}

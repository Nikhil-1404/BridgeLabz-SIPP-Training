// Superclass
class BankAccount {
    public String accountNumber;      // public
    protected String accountHolder;   // protected
    private double balance;           // private

    // Constructor
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;  // default balance
    }

    // Setter for balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);   // public
        System.out.println("Account Holder: " + accountHolder);   // protected
        // Cannot access balance directly (private)
    }
}

// Main test class
 class Main {
    public static void main(String[] args) {
        // Create BankAccount object
        BankAccount bankAcc = new BankAccount("ACC12345", "Alice");
        bankAcc.deposit(1000);
        bankAcc.withdraw(200);

        System.out.println("Bank Account Details:");
        System.out.println("Account Number: " + bankAcc.accountNumber);
        System.out.println("Account Holder: " + bankAcc.accountHolder);
        System.out.println("Balance: $" + bankAcc.getBalance());

        // Create SavingsAccount object
        SavingsAccount savingsAcc = new SavingsAccount("SAV67890", "Bob");
        savingsAcc.deposit(5000);

        System.out.println("\nSavings Account Details:");
        savingsAcc.displayAccountInfo();
        System.out.println("Balance: $" + savingsAcc.getBalance());
    }
}

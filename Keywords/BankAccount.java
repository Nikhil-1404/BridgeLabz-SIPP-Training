class BankAccount {
    // 1. Static variable shared by all accounts
    static String bankName = "National Bank";
    static int totalAccounts = 0;

    // 3. Final variable - cannot be modified after assignment
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor using 'this' to resolve ambiguity
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;             // this resolves variable name conflict
        this.accountHolderName = accountHolderName;
        this.balance = balance;

        // Increment static account counter
        totalAccounts++;
    }

    // Static method to display total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }
}

 class Main {
    public static void main(String[] args) {
        // Creating accounts
        BankAccount acc1 = new BankAccount(1001, "Amit", 5000.0);
        BankAccount acc2 = new BankAccount(1002, "Neha", 7500.0);

        // 4. instanceof check before displaying details
        if (acc1 instanceof BankAccount) {
            System.out.println("Account 1 Details:");
            acc1.displayDetails();
        }

        if (acc2 instanceof BankAccount) {
            System.out.println("\nAccount 2 Details:");
            acc2.displayDetails();
        }

        // Calling static method
        BankAccount.getTotalAccounts();
    }
}

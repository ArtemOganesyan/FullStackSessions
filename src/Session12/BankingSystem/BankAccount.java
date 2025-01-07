package Session12.BankingSystem;

abstract class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double accountBalance;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            accountBalance -= amount;
        } else {
            System.out.println("Invalid withdraw amount");
        }
    }

    public abstract void displayAccountData();
}

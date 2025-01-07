package Session12.BankingSystem;

public class SavingsAccount extends BankAccount implements Transaction {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        // Calculate interest and deposit it
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: $" + interest);
    }

    @Override
    public void displayAccountData() {
        System.out.println("Savings Account: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolderName());
        System.out.println("Balance: $" + getBalance());
        System.out.println("Interest rate: " + interestRate);
    }
}

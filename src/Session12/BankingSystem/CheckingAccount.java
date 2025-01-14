package Session12.BankingSystem;

public class CheckingAccount extends BankAccount implements Transaction, Reporting {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InvalidWithdrawalException {
        // Checking account can withdraw up to the overdraft limit
        if (amount > 0 && (getBalance() + overdraftLimit - amount >= 0)) {
            super.withdraw(amount);
        } else {
            throw new InvalidWithdrawalException("Not enough funds.");
        }
    }

    @Override
    public void displayAccountData() {
        System.out.println("Checking account: " + getAccountNumber());
        System.out.println("Account holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Overdraft: " + overdraftLimit);
    }

    @Override
    public void report() {

    }
}

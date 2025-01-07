package Session12.BankingSystem;

public class CheckingAccount extends BankAccount implements Transaction {

    public CheckingAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance);
    }

    @Override
    public void displayAccountData() {
        System.out.println("Checking account: " + getAccountNumber());
        System.out.println("Account holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
    }
}

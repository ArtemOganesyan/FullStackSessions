package Session12.BankingSystem;

public interface Transaction {
    void deposit(double amount) throws InvalidDepositException;
    void withdraw (double amount) throws InvalidWithdrawalException;
}

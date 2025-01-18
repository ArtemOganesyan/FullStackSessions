package Session17;

/**
 * Represents a bank account with basic operations.
 * <p>
 * This class allows deposits, withdrawals, and balance inquiries.
 * </p>
 *
 * @author Artem Oganesyan
 * @version 1.0
 * @see java.util.Date
 */
public class BankAccount {

    private double balance;

    /**
     * Creates a bank account with a zero balance.
     */
    public BankAccount() {
        this.balance = 0.0;
    }

    /**
     * Deposits a specified amount into the account.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is negative
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        balance += amount;
    }

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is negative or exceeds balance
     */
    public void withdraw(double amount) {
        if (amount < 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        balance -= amount;
    }

    /**
     * Gets the current balance of the account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
}


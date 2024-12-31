package Session10;

import javax.swing.plaf.basic.BasicColorChooserUI;

public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    // deposit (amount >0)
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount should be > 0");
        }
    }

    //withdraw (<= balance, amount > 0)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            setBalance(balance - amount);
            System.out.println("Withdrawn: " + amount + " new balance: " + getBalance());
        } else {
            System.out.println("Not enough funds or amount is incorrect");
        }
    }
}

package Session12.BankingSystem;

import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.exit;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        // Main menu
        System.out.println("Choose an account");
        System.out.println("1. Checking account");
        System.out.println("2. Savings account");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Common account details
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();

        // Account creation with specific details
        if (choice == 1) {
            // checking
            System.out.println("Enter overdraft limit: ");
            double overdraftLimit = scanner.nextDouble();
            account = new CheckingAccount(accountNumber, accountHolderName, balance, overdraftLimit);

        } else if (choice == 2) {
            // savings
            System.out.print("Enter Interest Rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(accountNumber, accountHolderName, balance, interestRate);
        }

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Account details");

            //Option for savings account only
            if (account instanceof SavingsAccount) {
                System.out.println("5. Calculate interest");
            }

            System.out.println("0. Exit");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawAmount);
                    } catch (InvalidWithdrawalException error) {
                        System.out.println(error.getMessage());
                    }

                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    account.displayAccountData();
                    break;
                case 5:
                    // Calculate interest for savings account
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).calculateInterest();
                    } else {
                        System.out.println("Invalid option.");
                        break;
                    }
                    break;
                case 0:
                    exit(0);
            }
        }
    }
}

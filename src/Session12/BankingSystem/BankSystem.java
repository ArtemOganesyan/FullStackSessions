package Session12.BankingSystem;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("Choose an account");
        System.out.println("1. Checking account");
        System.out.println("2. Savings account");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();

        if (choice == 1) {
            // checking
            account = new CheckingAccount(accountNumber, accountHolderName, balance);
        } else if (choice == 2) {
            // savings
        }

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Account details");
            System.out.println("5. Exit");
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
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }
}

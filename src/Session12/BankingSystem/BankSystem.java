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


    }
}

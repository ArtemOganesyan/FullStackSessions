package Session5;

import java.util.Scanner;

public class SearchNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Correctly initialize the Scanner object
        System.out.println("Enter the number to search for: ");

        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int[] numbers = {24,54,67,54,32,33,47,39};
            boolean found = false;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == num) {
                    found = true;
                    System.out.println("Number found: " + num);
                    break;
                }
            }
            if (!found) {
                System.out.println("Number not found.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}

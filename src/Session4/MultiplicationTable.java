package Session4;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            int result = number*i;
            System.out.println(number + "*" + i + "=" + result);
        }
        scanner.close();
    }
}

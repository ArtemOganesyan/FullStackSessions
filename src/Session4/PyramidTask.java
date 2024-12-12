package Session4;

import java.util.Scanner;

public class PyramidTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        int k = 0;
        for (int i = 1; i <= rows; ++i, k = 0) {
            for (int space = 1; space <= rows - i; ++space) {
                System.out.print("  ");
            }
            while (k != 2 * i - 1) {
            System.out.print("* ");
            ++k;
            }
            System.out.println();
        }
        scanner.close();
    }
}
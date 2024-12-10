package Session3;

import java.util.Scanner;

public class IfSample {
    public static void main(String[] args) {
        System.out.println("If statement example");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your score: ");
        int score = scanner.nextInt();
        // score 90 or above - grade A
        // score from 80 to 89 - grade B
        // score from 70 to 79 - grade C
        // score from 60 to 69 - grade D
        // score below 60 - grade F

        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 80) {
            System.out.println("Grade B");
        } else if (score >= 70) {
            System.out.println("Grade C");
        } else if (score >= 60) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }
        scanner.close();
    }
}

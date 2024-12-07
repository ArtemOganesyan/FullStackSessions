package Session2;

import java.util.Scanner;

public class StudentDetails {
    public static void main(String[] args) {
        // Student identifier
        // Student firstname
        // Student lastname
        // Student age

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student identifier: ");
        int studentId = scanner.nextInt();
        System.out.println("Enter student first name: ");
        String firstName = scanner.next();
        System.out.println("Enter student last name: ");
        String lastName = scanner.next();
        System.out.println("Enter student age: ");
        int age = scanner.nextInt();

        System.out.println("\n ====== Student details ======");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student name: " + firstName + " " + lastName);
        System.out.println("Student age: " + age);
        System.out.println(" ====== Student details ======");
        scanner.close();

    }
}

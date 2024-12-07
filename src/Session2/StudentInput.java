package Session2;

import java.util.Scanner;

public class StudentInput {
    public static void main(String[] args) {
        Student student = new Student();
        student.inputDetails();
        student.displayStudent();
    }
}

class Student {
    int id;
    String firstName;
    String lastName;
    int age;

    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student identifier: ");
        id = scanner.nextInt();
        System.out.println("Enter student first name: ");
        firstName = scanner.next();
        System.out.println("Enter student last name: ");
        lastName = scanner.next();
        System.out.println("Enter student age: ");
        age = scanner.nextInt();
    }

    public void displayStudent() {
        System.out.println("\n ====== Student details ======");
        System.out.println("Student ID: " + id);
        System.out.println("Student name: " + firstName + " " + lastName);
        System.out.println("Student age: " + age);
        System.out.println(" ====== Student details ======");
    }
}
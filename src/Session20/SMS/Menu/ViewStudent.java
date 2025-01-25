package Session20.SMS.Menu;

import Session20.SMS.Student;
import Session20.SMS.StudentMajorComparator;
import Session20.SMS.StudentNameComparator;
import Session20.SMS.StudentService;

import java.util.Scanner;

public class ViewStudent {
    private StudentService studentService;
    private Scanner scanner;

    public ViewStudent(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    public void execute() {
        if (studentService.getStudents().isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("View students by:");
        System.out.println("1. Name");
        System.out.println("2. Major");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                studentService.getStudents().sort(new StudentNameComparator());
                break;
            case 2:
                studentService.getStudents().sort(new StudentMajorComparator());
                break;
            default:
                System.out.println("Invalid choice. Displaying unsorted list.");
        }

        // Print table header
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", "Type", "ID", "First Name", "Last Name", "Age", "Major", "GPA");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

        // Print each student
        for (Student student : studentService.getStudents()) {
            student.print();
        }
    }
}

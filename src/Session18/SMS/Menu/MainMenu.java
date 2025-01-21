package Session18.SMS.Menu;

import Session18.SMS.StudentService;

import java.util.Scanner;

public class MainMenu {
    private StudentService studentService;
    private Scanner scanner;

    public MainMenu(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("Students count: " + studentService.getStudents().size());
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Edit student");
            System.out.println("4. Delete Student");
            System.out.println("0. Save and Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    new AddStudent(studentService, scanner).execute();
                    break;
                case 2:
                    new ViewStudent(studentService, scanner).execute();
                    break;
                case 3:
                    new EditStudent(studentService, scanner).execute();
                    break;
                case 4:
                    new DeleteStudent(studentService, scanner).execute();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    studentService.saveStudents();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

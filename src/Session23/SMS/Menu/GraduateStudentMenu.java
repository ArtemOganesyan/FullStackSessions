package Session23.SMS.Menu;

import Session23.SMS.GraduateStudent;
import Session23.SMS.Graduation;
import Session23.SMS.Student;
import Session23.SMS.StudentService;

import java.util.Scanner;

public class GraduateStudentMenu {
    private StudentService studentService;
    private Scanner scanner;

    public GraduateStudentMenu(StudentService service, Scanner scanner) {
        this.studentService = service;
        this.scanner = scanner;
    }

    public void execute() {
        // Prompt for student id
        System.out.println("Enter the student ID to graduate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        GraduateStudent graduatedStudent = Graduation.graduationFor(id, gpa, studentService);

        if (graduatedStudent != null) {
            System.out.println("Student graduated.");
        } else {
            System.out.println("Student not found or already graduated");
        }
    }
}

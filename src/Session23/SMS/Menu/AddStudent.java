package Session23.SMS.Menu;

import Session23.SMS.*;

import java.util.Scanner;

public class AddStudent {
    private StudentService studentService;
    private Scanner scanner;

    public AddStudent(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter student type (1 for Undergraduate, 2 for Graduate): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter major (ART, ECONOMICS, MATH): ");
        String majorStr = scanner.nextLine();
        Major major = Major.valueOf(majorStr.toUpperCase());

        Student student;
        if (type == 1) {
            student = new UndergradStudent(studentService.getStudents().size() + 1, firstName, lastName, age, major);
        } else if (type == 2) {
            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            GraduateStudent gradStudent = new GraduateStudent(studentService.getStudents().size() + 1, firstName, lastName, age, major);
            try {
                gradStudent.setGPA(gpa);
            } catch (IllegalGpaException e) {
                System.out.println("Invalid GPA: " + e.getMessage());
                return;
            }
            student = gradStudent;
        } else {
            System.out.println("Invalid student type.");
            return;
        }

        studentService.addStudent(student);
        System.out.println("Student added successfully.");
    }
}
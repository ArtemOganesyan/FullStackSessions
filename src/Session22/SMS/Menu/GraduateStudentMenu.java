package Session22.SMS.Menu;

import Session22.SMS.GraduateStudent;
import Session22.SMS.Student;
import Session22.SMS.StudentService;

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

        // Find the student - Check for student existance or graduated
        Student student = studentService.getStudents()
                                        .stream()
                                        .filter(s -> s.getId() == id)
                                        .findFirst()
                                        .orElse(null);
        if (student != null | !(student instanceof GraduateStudent)) {
            // Ask for GPA
            System.out.println("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            // Create GraduteStudent
            GraduateStudent graduateStudent = new GraduateStudent(student.getId(),
                                                                student.getFirstName(),
                                                                student.getLastName(),
                                                                student.getAge(),
                                                                student.getMajor());
            try {
                graduateStudent.setGPA(gpa);
            } catch (Exception e) {
                System.out.println("Invalid GPA: " + e.getMessage());
            }
            // Delete undergrad student
            studentService.deleteStudent(id);
            // Add graduate student to a student list
            studentService.addStudent(graduateStudent);
            System.out.println("Student graduated.");
        } else {
            System.out.println("Student not found or already graduated");
        }
    }
}

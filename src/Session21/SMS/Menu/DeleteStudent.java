package Session21.SMS.Menu;

import Session21.SMS.Student;
import Session21.SMS.StudentService;

import java.util.Scanner;

public class DeleteStudent {
    private StudentService studentService;
    private Scanner scanner;

    public DeleteStudent(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student studentToRemove = null;
        for (Student student : studentService.getStudents()) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentService.getStudents().remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}

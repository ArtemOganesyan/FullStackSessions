package Session17.SMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A menu-driven student management system.
 */
public class MenuDrivenSMS {
    private static final String FILE_NAME = "students.csv";
    private static List<Student> students = new ArrayList<>();

    /**
     * The main method to run the student management system.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        students = Utility.loadStudentsFromFile(FILE_NAME);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("Students count: " + students.size());
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
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents(scanner);
                    break;
                case 3:
                    editStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    Utility.saveStudentsToFile(students, FILE_NAME);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a new student to the system.
     *
     * @param scanner the scanner to read user input
     */
    private static void addStudent(Scanner scanner) {
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
            student = new UndergradStudent(firstName, lastName, age, major);
        } else if (type == 2) {
            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            GraduateStudent gradStudent = new GraduateStudent(firstName, lastName, age, major);
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

        students.add(student);
        System.out.println("Student added successfully.");
    }

    /**
     * Displays the list of students.
     */
    private static void viewStudents(Scanner scanner) {
        if (students.isEmpty()) {
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
                students.sort(new StudentNameComparator());
                break;
            case 2:
                students.sort(new StudentMajorComparator());
                break;
            default:
                System.out.println("Invalid choice. Displaying unsorted list.");
        }

        // Print table header
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", "Type", "ID", "First Name", "Last Name", "Age", "Major", "GPA");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

        // Print each student
        for (Student student : students) {
            student.print();
        }
    }

    /**
     * Deletes a student from the system.
     *
     * @param scanner the scanner to read user input
     */
    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    /**
     * Edits the details of an existing student.
     *
     * @param scanner the scanner to read user input
     */
    private static void editStudent(Scanner scanner) {
        System.out.print("Enter student ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student studentToEdit = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToEdit = student;
                break;
            }
        }

        if (studentToEdit == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        System.out.print("Enter new first name (leave blank to keep current): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) {
            studentToEdit.setFirstName(firstName);
        }

        System.out.print("Enter new last name (leave blank to keep current): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            studentToEdit.setLastName(lastName);
        }

        System.out.print("Enter new age (leave blank to keep current): ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isEmpty()) {
            int age = Integer.parseInt(ageStr);
            studentToEdit.setAge(age);
        }

        System.out.print("Enter new major (leave blank to keep current): ");
        String majorStr = scanner.nextLine();
        if (!majorStr.isEmpty()) {
            Major major = Major.valueOf(majorStr.toUpperCase());
            studentToEdit.major = major;
        }

        if (studentToEdit instanceof GraduateStudent) {
            System.out.print("Enter new GPA (leave blank to keep current): ");
            String gpaStr = scanner.nextLine();
            if (!gpaStr.isEmpty()) {
                double gpa = Double.parseDouble(gpaStr);
                try {
                    ((GraduateStudent) studentToEdit).setGPA(gpa);
                } catch (IllegalGpaException e) {
                    System.out.println("Invalid GPA: " + e.getMessage());
                }
            }
        }

        System.out.println("Student details updated successfully.");
    }
}
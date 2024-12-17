package Session6;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    static class Student {
        int studentId;
        String firstName;
        String lastName;
        int studentAge;

        Student(int id, String fName, String lName, int Age) {
            this.studentId = id;
            this.firstName = fName;
            this.lastName = lName;
            this.studentAge = Age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Student[] students = new Student[5];
        ArrayList<Student> students = new ArrayList<>();
        int studentCount = 0;

        while (true) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Enter student details");
            System.out.println("2. Display student details");
            System.out.println("3. Delete student");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    boolean idExists = false;
                    System.out.println("Enter student id: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

//                    for (int i = 0; i < studentCount; i++) {
//                        if (students[i].studentId == studentId) {
//                            idExists = true;
//                            break;
//                        }
//                    }
                    try {
                        students.get(studentId);
                        idExists = true;
                        break;
                    } catch (IndexOutOfBoundsException e) {

                    }
                    if (idExists) {
                        System.out.println("Student with id " + studentId + " already exists");
                        break;
                    }

                    System.out.println("Enter student first name: ");
                    String firstName = scanner.next();

                    System.out.println("Enter student last name: ");
                    String lastName = scanner.next();

                    System.out.println("Enter student age: ");
                    int studentAge = scanner.nextInt();

                    Student student = new Student(studentId, firstName, lastName, studentAge);

                    //students[studentCount] = student;
                    students.add(student);
                    //studentCount++;

                    System.out.println("Information saved successfully");
                    break;
                case 2:
                    for (int i = 0; i < students.size(); i++) {
                        Student s = students.get(i);
                        System.out.println("===== Student Details =====");
                        System.out.println("Student ID: " + s.studentId);
                        System.out.println("First Name: " + s.firstName);
                        System.out.println("Last Name: " + s.lastName);
                        System.out.println("Age: " + s.studentAge);
                        System.out.println("===== End of Student Details =====");
                    }
                    break;

                case 3:
                    // Provide an option to delete a student
                    System.out.println("Enter student id to delete: ");
                    int id = scanner.nextInt();
                    idExists = false; // Use the existing variable
//                    for (int i = 0; i < studentCount; i++) {
//                        if (students[i].studentId == id) {
//                            students[i] = null;
//                            System.out.println("Student deleted successfully");
//                            idExists = true;
//                            break;
//                        }
//                    }
                    students.remove(id);
                    System.out.println("Student deleted successfully");
                    if (!idExists) {
                        System.out.println("Student with id " + id + " does not exist");
                    }
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

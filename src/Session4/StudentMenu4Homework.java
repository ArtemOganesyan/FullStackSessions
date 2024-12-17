package Session4;

import java.util.Scanner;

public class StudentMenu4Homework {

    static class Student {
        int studentId;
        String firstName;
        String lastName;
        int studentAge;

        Student (int id, String fName, String lName, int age) {
            this.studentId = id;
            this.firstName = fName;
            this.lastName = lName;
            this.studentAge = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[5];
        int studentCount = 0;
        //Student student = new Student( 0, "", "", 0);

        while (true) {
            System.out.println("======== Student Menu ========");
            System.out.println("1. Add Student Details");
            System.out.println("2. View Student Details");
            System.out.println("3. Reset Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:                                               // Add student details
                    while (true) {
                        System.out.print("\nEnter student ID: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();

                        // Check if the student ID is unique
                        boolean isUnique = true;
                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].studentId == studentId) {
                                isUnique = false;
                                break;
                            }
                        }

                        if (!isUnique) {
                            System.out.println("\nStudent ID already exists. Please enter a unique ID.");
                        } else {
                            System.out.print("Enter first name: ");
                            String firstName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                            while (true) {                                                               // Ask first name until it is between 3 and 15 characters
                                if (firstName.length() < 3 || firstName.length() > 15) {
                                    System.out.println("\nFirst name should be between 3 and 15 characters\n");
                                    System.out.print("Enter first name: ");
                                    firstName = scanner.next().trim();
                                } else {
                                    break;
                                }
                            }

                            System.out.print("Enter last name: ");
                            String lastName = scanner.next().trim().replaceAll("\\s", "");    // Remove white spaces
                            while (true) {                                                              // Ask last name until it is between 3 and 15 characters
                                if (lastName.length() < 3 || lastName.length() > 15) {
                                    System.out.println("\nLast name should be between 3 and 15 characters\n");
                                    System.out.print("Enter last name: ");
                                    lastName = scanner.next().trim();
                                } else {
                                    break;
                                }
                            }

                            System.out.print("Enter student age: ");
                            int studentAge = scanner.nextInt();
                            scanner.nextLine();

                            Student student = new Student(studentId, firstName, lastName, studentAge);

                            students[studentCount] = student;
                            studentCount++;

                            System.out.println("\nInformation added successfully");
                            System.out.println();
                            break;
                        }
                    }
                    break;
                case 2:                                                      // View student details
                    if (studentCount == 0) {
                        System.out.println("\nNo student details available.\n");
                    } else {
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println("\nStudent ID: " + students[i].studentId);
                            System.out.println("First Name: " + students[i].firstName);
                            System.out.println("Last Name: " + students[i].lastName);
                            System.out.println("Student Age: " + students[i].studentAge);
                            System.out.println();
                        }
                    }
                    break;
                case 3:                                                       // Reset student details
                    System.out.print("\nEnter student id to delete student details: ");
                    int studentIdToDelete = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].studentId == studentIdToDelete) {
                            found = true;
                            for (int j = i; j < studentCount - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            students[studentCount - 1] = null;
                            studentCount--;
                            System.out.println("\nStudent details successfully deleted!\n");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nStudent ID not found.\n");
                    }
                    break;
                case 4:                                                       // Exit
                    scanner.close();
                    System.exit(0);
                    break;
                default:                                                      // Invalid option
                    System.out.print("\nNot supported option,\nPlease try again!\n\n");
            }
        }
    }
}

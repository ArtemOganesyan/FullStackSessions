package Session4;

import java.util.Scanner;

public class studentManag {
    static class  Student {
        int studentid;
        String fistname;
        String lastname;
        int age;

        Student(int id, String fName, String lName, int age){
            this.studentid = id;
            this.fistname = fName;
            this.lastname = lName;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[5];
        int studentCount = 0;
        //Student student = new Student(0, "", "", 0);

        while(true){
            System.out.println("========Student=======");
            System.out.println("1. Enter Student Details");
            System.out.println("2. Display Student Details");
            System.out.println("3. Reset Student Data");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    boolean idFound = false;
                    System.out.println("Enter your ID: ");
                    int studentid = scanner.nextInt();

                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].studentid == studentid) {
                            System.out.println("Student with this ID already exists.");
                            idFound = true;
                            break;
                        }
                    }
                    if (idFound) {
                        break;
                    }
                    System.out.println("Enter your first name: ");
                    String fistname = scanner.next();
                    System.out.println("Enter your last name: ");
                    String lastname = scanner.next();
                    System.out.println("Enter your age: ");
                    int age = scanner.nextInt();

                    Student student = new Student(studentid,
                            fistname,
                            lastname,
                            age);
                    students[studentCount] = student;
                    studentCount++;
                    System.out.println("Student details entered successfully.");
                    break;
                case 2:
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i] != null) {
                            System.out.println("\n =========Student Details========");
                            System.out.println("ID: " + students[i].studentid);
                            System.out.println("First Name: " + students[i].fistname);
                            System.out.println("Last Name: " + students[i].lastname);
                            System.out.println("Age: " + students[i].age);
                        }
                    }
                    if (studentCount == 0) {
                        System.out.println("No student data found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student id to delete: ");
                    int id = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].studentid == id) {
                            found = true;
                            for (int j = i; j < studentCount - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            students[studentCount - 1] = null;
                            studentCount--;
                            System.out.println("Student deleted successfully.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student ID not found.");
                    }
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }
        }
    }
}
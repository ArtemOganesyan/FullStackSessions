package Session22.SMS;

import Session22.SMS.Menu.MainMenu;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Main class is the entry point for the Student Management System application.
 * It initializes the necessary components and displays the main menu.
 */
public class Main {
    /**
     * The main method initializes the StudentRepository, StudentService, and Scanner,
     * then creates and displays the MainMenu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        StudentRepository studentRepository = new FileStudentRepository("students.csv");
        StudentService studentService = new StudentService(studentRepository);

        // Start the HTTP server
        try {
            StudentHttpServer server = new StudentHttpServer(studentService);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(studentService, scanner);
        mainMenu.displayMenu();
    }
}
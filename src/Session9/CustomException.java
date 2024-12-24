package Session9;

import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be > 18");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Age: ");
        int age = scanner.nextInt();

        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

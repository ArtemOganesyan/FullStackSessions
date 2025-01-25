package Session20.SMS;

/**
 * Exception thrown when an illegal GPA value is encountered.
 */
public class IllegalGpaException extends Exception {
    /**
     * Constructs a new IllegalGpaException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalGpaException(String message) {
        super(message);
    }
}
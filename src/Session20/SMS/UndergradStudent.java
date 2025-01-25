package Session20.SMS;

/**
 * The UndergradStudent class represents an undergraduate student and extends the Student class.
 * It includes methods specific to undergraduate students.
 */
public class UndergradStudent extends Student implements Printable {

    /**
     * Constructs an UndergradStudent with the specified details.
     *
     * @param id the student's ID
     * @param firstName the student's first name
     * @param lastName the student's last name
     * @param age the student's age
     * @param major the student's major
     */
    public UndergradStudent(int id, String firstName, String lastName, int age, Major major) {
        super(id, firstName, lastName, age, major);
    }

    /**
     * Prints the details of the undergraduate student in a formatted table.
     */
    @Override
    public void print() {
        System.out.format("| %-15s | %-15d | %-15s | %-15s | %-15d | %-15s | %-15s |%n",
                "Undergraduate", getId(), getFirstName(), getLastName(), getAge(), major, "");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
    }
}
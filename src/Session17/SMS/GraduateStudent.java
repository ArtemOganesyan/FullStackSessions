package Session17.SMS;

/**
 * Represents a graduate student.
 */
public class GraduateStudent extends Student implements Printable {
    private double GPA;

    /**
     * Constructs a new GraduateStudent with the specified details.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public GraduateStudent(String firstName, String lastName, int age, Major major) {
        super(firstName, lastName, age, major);
    }

    /**
     * Constructs a new GraduateStudent with the specified details.
     *
     * @param id        the ID of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public GraduateStudent(int id, String firstName, String lastName, int age, Major major) {
        super(id, firstName, lastName, age, major);
    }

    /**
     * Returns the GPA of the student.
     *
     * @return the GPA of the student
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Sets the GPA of the student.
     *
     * @param GPA the GPA to set
     * @throws IllegalGpaException if the GPA is not between 0 and 4
     */
    public void setGPA(double GPA) throws IllegalGpaException {
        if (GPA < 0 || GPA > 4) {
            throw new IllegalGpaException("GPA must be between 0 and 4.");
        }
        this.GPA = GPA;
    }

    /**
     * Prints the details of the graduate student in a table format.
     */
    @Override
    public void print() {
        System.out.format("| %-15s | %-15d | %-15s | %-15s | %-15d | %-15s | %-15.2f |%n",
                "Graduate", getId(), getFirstName(), getLastName(), getAge(), major, getGPA());
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
    }
}
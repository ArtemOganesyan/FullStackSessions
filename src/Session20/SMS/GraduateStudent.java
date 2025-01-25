package Session20.SMS;

/**
 * The GraduateStudent class represents a graduate student and extends the Student class.
 * It includes additional attributes and methods specific to graduate students.
 */
public class GraduateStudent extends Student implements Printable {
    private double gpa;

    /**
     * Constructs a GraduateStudent with the specified details.
     *
     * @param id the student's ID
     * @param firstName the student's first name
     * @param lastName the student's last name
     * @param age the student's age
     * @param major the student's major
     */
    public GraduateStudent(int id, String firstName, String lastName, int age, Major major) {
        super(id, firstName, lastName, age, major);
    }

    /**
     * Gets the GPA of the graduate student.
     *
     * @return the GPA of the graduate student
     */
    public double getGPA() {
        return gpa;
    }

    /**
     * Sets the GPA of the graduate student.
     *
     * @param gpa the GPA to set
     * @throws IllegalGpaException if the GPA is not between 0.0 and 4.0
     */
    public void setGPA(double gpa) throws IllegalGpaException {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalGpaException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
    }

    /**
     * Prints the details of the graduate student in a formatted table.
     */
    @Override
    public void print() {
        System.out.format("| %-15s | %-15d | %-15s | %-15s | %-15d | %-15s | %-15.2f |%n",
                "Graduate", getId(), getFirstName(), getLastName(), getAge(), major, gpa);
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
    }
}
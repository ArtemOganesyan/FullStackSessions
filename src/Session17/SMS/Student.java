package Session17.SMS;

/**
 * Abstract class representing a student.
 */
public abstract class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    public Major major;

    private static int nextId = 1;
    private static int studentCount = 0;

    /**
     * Constructs a new Student with the specified details.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public Student(String firstName, String lastName, int age, Major major) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        studentCount++;
    }

    /**
     * Constructs a new Student with the specified details.
     *
     * @param id        the ID of the student
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param age       the age of the student
     * @param major     the major of the student
     */
    public Student(int id, String firstName, String lastName, int age, Major major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        studentCount++;
    }

    /**
     * Returns the ID of the student.
     *
     * @return the ID of the student
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the first name of the student.
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the student.
     *
     * @return the last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the age of the student.
     *
     * @return the age of the student
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the student.
     *
     * @param age the age to set
     * @throws IllegalArgumentException if the age is not between 18 and 150
     */
    public void setAge(int age) {
        if (age < 18 || age > 150) {
            throw new IllegalArgumentException("Age must be between 18 and 150.");
        }
        this.age = age;
    }

    /**
     * Sets the next ID for the student.
     *
     * @param nextId the next ID to set
     */
    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    /**
     * Prints the details of the student.
     */
    public abstract void print();

    /**
     * Returns a string representation of the student.
     *
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        return String.format("ID: %d, First Name: %s, Last Name: %s, Age: %d, Major: %s", id, firstName, lastName, age, major);
    }
}
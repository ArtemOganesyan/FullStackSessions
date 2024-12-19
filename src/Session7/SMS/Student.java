package Session7.SMS;

public class Student {
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

    public String toString() {
        //return studentId + " " + firstName + " " + lastName;
        return String.format("ID: %d, First name: %s, Last name: %s",
                studentId,
                firstName,
                lastName);
    }
}

package Session18.SMS;

import java.util.Comparator;

/**
 * Comparator for sorting students by name.
 */
public class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getFirstName().compareTo(s2.getFirstName());
    }
}

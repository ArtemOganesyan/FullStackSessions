package Session18.SMS;

import java.util.List;

/**
 * The StudentRepository interface provides methods to load and save students.
 */
public interface StudentRepository {
    /**
     * Loads students from a data source.
     *
     * @return a list of students loaded from the data source
     */
    List<Student> loadStudents();

    /**
     * Saves students to a data source.
     *
     * @param students the list of students to save
     */
    void saveStudents(List<Student> students);
}
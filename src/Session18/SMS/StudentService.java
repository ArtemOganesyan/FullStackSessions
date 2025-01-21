package Session18.SMS;

import java.util.List;

/**
 * The StudentService class provides methods to manage students, including adding, deleting, and saving students.
 */
public class StudentService {
    private StudentRepository studentRepository;
    private List<Student> students;

    /**
     * Constructs a StudentService with the specified StudentRepository.
     *
     * @param studentRepository the StudentRepository to manage student data
     */
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.students = studentRepository.loadStudents();
    }

    /**
     * Gets the list of students.
     *
     * @return the list of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the list.
     *
     * @param student the student to add
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id the ID of the student to delete
     */
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    /**
     * Saves the list of students to the repository.
     */
    public void saveStudents() {
        studentRepository.saveStudents(students);
    }
}
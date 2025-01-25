package Session20.SMS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for loading and saving students to and from a file.
 */
public class Utility {

    /**
     * Loads students from a specified file.
     *
     * @param fileName the name of the file to load students from
     * @return a list of students loaded from the file
     */
    public static List<Student> loadStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        File file = new File(fileName);
        int maxId = 0;
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    String type = data[0];
                    int id = Integer.parseInt(data[1]);
                    String firstName = data[2];
                    String lastName = data[3];
                    int age = Integer.parseInt(data[4]);
                    Major major = Major.valueOf(data[5]);
                    if ("GraduateStudent".equals(type)) {
                        GraduateStudent gradStudent = new GraduateStudent(id, firstName, lastName, age, major);
                        try {
                            gradStudent.setGPA(Double.parseDouble(data[6]));
                        } catch (IllegalGpaException e) {
                            System.out.println("Invalid GPA: " + e.getMessage());
                        }
                        students.add(gradStudent);
                    } else if ("UndergradStudent".equals(type)) {
                        UndergradStudent undergradStudent = new UndergradStudent(id, firstName, lastName, age, major);
                        students.add(undergradStudent);
                    }
                    if (id > maxId) {
                        maxId = id;
                    }
                }
                Student.setNextId(maxId + 1);
                System.out.println("Loaded " + students.size() + " students from file.");
            } catch (IOException e) {
                System.out.println("Error loading students from file: " + e.getMessage());
            }
        }
        return students;
    }

    /**
     * Saves students to a specified file.
     *
     * @param students the list of students to save
     * @param fileName the name of the file to save students to
     */
    public static void saveStudentsToFile(List<Student> students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                StringBuilder studentData = new StringBuilder();
                if (student instanceof GraduateStudent) {
                    GraduateStudent gradStudent = (GraduateStudent) student;
                    studentData.append("GraduateStudent,")
                            .append(gradStudent.getId()).append(",")
                            .append(gradStudent.getFirstName()).append(",")
                            .append(gradStudent.getLastName()).append(",")
                            .append(gradStudent.getAge()).append(",")
                            .append(gradStudent.major).append(",")
                            .append(gradStudent.getGPA()).append("\n");
                } else if (student instanceof UndergradStudent) {
                    UndergradStudent undergradStudent = (UndergradStudent) student;
                    studentData.append("UndergradStudent,")
                            .append(undergradStudent.getId()).append(",")
                            .append(undergradStudent.getFirstName()).append(",")
                            .append(undergradStudent.getLastName()).append(",")
                            .append(undergradStudent.getAge()).append(",")
                            .append(undergradStudent.major).append("\n");
                }
                writer.write(studentData.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }
}
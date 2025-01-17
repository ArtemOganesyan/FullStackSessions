package Session16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SaveCsvExample {

    public static void main(String[] args) {
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1, "Artem", 43, 2));
//        studentList.add(new Student(1, "Tim", 43, 2));
//        studentList.add(new Student(1, "Olga", 43, 2));
//
//        saveStudentsToCsv(studentList);
        for (Student s : loadStudents()) {
            System.out.println(s);
        }
    }

    public static void saveStudentsToCsv (List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("student.csv"))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<Student> loadStudents() {
        List<Student> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(Student.fromCSV(line));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

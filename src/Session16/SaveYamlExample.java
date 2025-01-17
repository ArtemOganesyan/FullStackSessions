package Session16;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class SaveYamlExample {
    public static void main(String[] args) {
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1, "Artem", 43, 2));
//        studentList.add(new Student(1, "Tim", 43, 2));
//        studentList.add(new Student(1, "Olga", 43, 2));
//
//        saveYaml(studentList);
        for (Student s : loadFromYaml()) {
            System.out.println(s);
        }
    }

    public static void saveYaml (List<Student> students) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File("students.yaml"), students);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<Student> loadFromYaml() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<Student> result = new ArrayList<>();
        try {
            result = mapper.readValue(new File("students.yaml"), mapper.getTypeFactory().constructCollectionType(List.class, Student.class));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

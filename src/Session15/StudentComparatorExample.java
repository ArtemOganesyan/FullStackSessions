package Session15;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private int Id;
    private String name;
    private int age;
    private double grade;

    public Student(int id, String name, int age, double grade) {
        this.Id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() { return Id; }
    public String getName() { return name; }
    public int age() { return age; }
    public double grade() { return grade; }
}

class NameComparatorAscending implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
//        int result = 0;
//        String firstStudentName = s1.getName();
//        String secondStudentName = s2.getName();
//        result = firstStudentName.compareTo(secondStudentName);
//        return result;
        return s1.getName().compareTo(s2.getName());
    }
}

class NameComparatorDescending implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s2.getName().compareTo(s1.getName());
    }
}

class GradeComparatorAscending implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.grade(), s2.grade());
    }
}

public class StudentComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "Tim", 23, 90.5));
        students.add(new Student(1, "Zara", 21, 89.4));
        students.add(new Student(1, "Zara", 20, 89.4));
        students.add(new Student(3, "Artem", 30, 95.0));

        Collections.sort(students, new NameComparatorAscending());
        for (Student s : students) {
            System.out.println(s.getName() + s.age());
        }
        System.out.println("----------");
        Collections.sort(students, new NameComparatorDescending());
        for (Student s: students) {
            System.out.println(s.getName());
        }
        System.out.println("----------");
        Collections.sort(students, new GradeComparatorAscending());
        for (Student s: students) {
            System.out.println(s.getName() + " grade: " + s.grade());
        }
    }
}

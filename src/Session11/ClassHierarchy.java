package Session11;

public class ClassHierarchy {
    public static void main(String[] args) {
        Person student = new Student();
        student.name = "Student";

        Person teacher = new Teacher();
        teacher.name = "Teacher";

        Person gradStudent = new GraduateStudent();
        gradStudent.name = "Graduated student";

        Person[] people = {student, teacher, gradStudent};

        for (Person person : people) {
            person.introduce();
        }
    }
}

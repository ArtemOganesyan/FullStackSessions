package Session11;

public class GraduateStudentSample {

    static void describeStudent(Student student) {
        if (student instanceof GraduateStudent) {
            System.out.println("This is graduate student");
        } else {
            System.out.println("This is a student");
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "John";
        student.age = 20;
        student.studentID = "1";

        GraduateStudent graduateStudent = new GraduateStudent();
        graduateStudent.name = "Lisa";
        graduateStudent.age = 25;
        graduateStudent.studentID = "123";
        graduateStudent.researchTopic = "Math";

        student.introduce();
        graduateStudent.introduce();

        describeStudent(student);
        describeStudent(graduateStudent);
    }
}

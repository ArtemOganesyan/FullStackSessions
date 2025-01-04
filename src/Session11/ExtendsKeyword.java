package Session11;

public class ExtendsKeyword {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Artem";
        person.age = 43;
        person.introduce();

        Student student = new Student();
        student.name = "Student";
        student.age = 30;
        student.studentID = "123";
        student.introduce();
        student.study();
    }
}

package Session8;

public class StaticVariable {
    static class Student {
        static int studentCount = 0;

        public Student() {
            studentCount++;
        }

        public static void showCount() {
            System.out.println("Number of students: " + studentCount);
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student.showCount();
    }
}

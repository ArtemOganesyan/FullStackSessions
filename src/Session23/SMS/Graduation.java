package Session23.SMS;

public class Graduation {
    private static StudentService studentService;

    public static GraduateStudent graduationFor(int id, double gpa, StudentService service) {
        studentService = service;
        GraduateStudent graduatedStudent = null;

        try {
            // Find the student - Check for student existance or graduated
            Student student = studentService.getStudents()
                    .stream()
                    .filter(s -> s.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (student != null && !(student instanceof GraduateStudent)) {

                // Create GraduteStudent
                GraduateStudent graduateStudent = new GraduateStudent(student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge(),
                        student.getMajor());
                try {
                    graduateStudent.setGPA(gpa);
                } catch (Exception e) {
                    throw new RuntimeException("Invalid GPA");
                }
                // Delete undergrad student
                studentService.deleteStudent(id);
                // Add graduate student to a student list
                studentService.addStudent(graduateStudent);
                studentService.saveStudents();
                graduatedStudent = graduateStudent;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return graduatedStudent;
    }
}

package Session11;

public class Student extends Person {
    String studentID;

    public void study() {
        System.out.println("I'm studying ...");
    }

    @Override
    public void introduce() {
        System.out.println("Hi I'm a student and my name is " + super.name);
    }
}

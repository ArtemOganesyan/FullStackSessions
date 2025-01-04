package Session11;

public class Teacher extends Person {
    String subject;

    public void teach() {
        System.out.println("I'm teaching");
    }

    @Override
    public void introduce() {
        System.out.println("I'm a teacher and my name is " + super.name);
    }
}

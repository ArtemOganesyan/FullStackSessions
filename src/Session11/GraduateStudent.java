package Session11;

public class GraduateStudent extends Student {
    String researchTopic;

    @Override
    public void introduce() {
        System.out.println("Hi, I am graduated " + researchTopic + " and my name is " + super.name);
    }
}

package Session8;

public class GettersSetters {
    public static void main(String[] args) {
        Person p = new Person();
//        p.firstName = "Artem";
//        p.lastName = "Oganesyan";
//        System.out.println(p.firstName + " " + p.lastName);
        p.setFirstName("");
        System.out.println(p.getFirstName());
    }
}

class Person {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName == "") {
            System.out.println("Empty name not allowed");
        } else {
            this.firstName = firstName;
        }
    }
}

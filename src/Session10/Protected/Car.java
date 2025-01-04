package Session10.Protected;

public class Car extends Vehicle {

    public Car(String type) {
        super(type);
    }

    public void displayType() {
        System.out.println("Car type is: " + getType());
    }
}

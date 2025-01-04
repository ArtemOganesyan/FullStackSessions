package Session10.Protected;

public class Vehicle {
    protected String type;

    public Vehicle(String type) {
        this.type = type;
    }

    protected String getType() {
        return type;
    }
}

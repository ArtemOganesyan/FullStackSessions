package Session12;

abstract class Vehicle {
    abstract void move();

    void fuel() {
        System.out.println("Fueling the vehicle ...");
    }
}

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("Car is moving ...");
    }
}

class Bicycle extends Vehicle {
    @Override
    void move() {
        System.out.println("Bicycle is moving ...");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        car.fuel();

        Bicycle bicycle = new Bicycle();
        bicycle.move();
        bicycle.fuel();
    }
}

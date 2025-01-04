package Session10;

import Session10.Protected.Car;



public class ProtectedDemo {

    public static void main(String[] args) {
        Car car = new Car("Toyota");
//        car.type = "Lexus";
        car.displayType();
    }
}

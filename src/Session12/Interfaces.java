package Session12;

interface Flyable {
    void fly();
}

interface Liftable {
    void lift();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying ...");
    }
}

class Plane implements Flyable, Liftable {
    @Override
    public void fly() {
        System.out.println("Plane is flying ...");
    }

    @Override
    public void lift() {
        System.out.println("Lifting 100 passangers ...");
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Flyable bird = new Bird();
        bird.fly();

        Plane plane = new Plane();
        plane.fly();
        plane.lift();
    }
}

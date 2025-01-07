package Session12;

abstract class Animal {
    void eat() {
        System.out.println("Animal is eating ...");
    }
}

interface Pet {
    void play();
}

class Cat extends Animal implements Pet {
    @Override
    public void play() {
        System.out.println("Cat is playing with the mouse ...");
    }
}

public class InterfacesAndAbstract {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.play();
    }
}

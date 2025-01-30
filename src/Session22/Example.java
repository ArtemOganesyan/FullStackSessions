package Session22;

abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    private String breed;
    public boolean canSee = true;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
}

class Cat extends Animal {
    private boolean isIndoor;
    public boolean canSee;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    private String breed;

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }
    public Cat(String name, boolean isIndoor) {
        super(name);
        this.isIndoor = isIndoor;
    }

    public static Cat fromDog(Dog dog, boolean isIndoor) {
        Cat newCat = new Cat(dog.getName(), isIndoor);
        if (dog.getBreed() == "Puddle") {
            newCat.setBreed("Puddle inherited");
        }
        newCat.canSee = dog.canSee;
        return newCat;
    }
}

public class Example {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "Puddle");
        Cat cat = Cat.fromDog(dog, false);
        System.out.println(cat.getName() + " " + cat.getBreed() + " " + cat.canSee);
    }
}

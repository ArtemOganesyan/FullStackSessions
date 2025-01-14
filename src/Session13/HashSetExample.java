package Session13;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();

        names.add("Tim");
        names.add("Gena");
        names.add("Steven");
        names.add("Tim");

        System.out.println("Names: " + names);

        boolean isAdded = names.add("Tim");
        System.out.println("Duplicate added: " + isAdded);

        boolean exists = names.contains("Tim");
        System.out.println("List contains Tim: " + exists);

        for (String name : names) {
            System.out.println(name);
        }

    }
}

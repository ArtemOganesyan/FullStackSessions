package Session15;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    int[] scores;

    public Person(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public double calcAgerage() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
}

public class LoggingExample {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", new int[]{5,7,8}));
        persons.add(new Person("Artem", new int[]{4,2,9}));
        persons.add(null);
        persons.add(new Person("Alice2", new int[]{5,7,8}));

        for (Person p : persons) {
            try {
                double avg = p.calcAgerage();
                System.out.println("Calculated: " + avg);
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }
    public static void log(String message) {
        try (FileWriter fw = new FileWriter("log.txt", true);
            PrintWriter pw = new PrintWriter(fw)) {
            pw.println("[MESSAGE] " + message);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}

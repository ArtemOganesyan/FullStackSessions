package Session14;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<Task> taskDeque = new ArrayDeque<>();
        taskDeque.addLast(new Task("Sample task 1", 3));
        taskDeque.addLast(new Task("Sample task 2", 5));
        taskDeque.addLast(new Task("Sample task 3", 4));
        taskDeque.addLast(new Task("Sample task 4", 1));

        taskDeque.forEach(System.out::println);
        System.out.println("---------------");
        while (!taskDeque.isEmpty()) {
            Task t = taskDeque.pollFirst();
            System.out.println(t.toString());
        }
    }

}

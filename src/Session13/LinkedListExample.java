package Session13;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");

        System.out.println(linkedList);
        linkedList.addFirst("Zero");
        System.out.println(linkedList);
        linkedList.addLast("Four");
        System.out.println(linkedList);

        for (String item : linkedList) {
            System.out.println(item);
        }
    }
}

package Session6;

import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentList = new HashMap<>();
        studentList.put(1, "Artem");
        studentList.put(26, "Vladyslav");
        studentList.put(3, "Gegam");
        studentList.put(4, "Nastia");

        System.out.println(studentList);

        studentList.put(2, "Elena");

        System.out.println(studentList);

        System.out.println(studentList.get(1));
        System.out.println(studentList.containsValue("Artem"));
    }
}

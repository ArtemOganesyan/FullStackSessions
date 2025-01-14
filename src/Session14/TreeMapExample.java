package Session14;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        String sample = "Java is a simple and Java is a powerful and simple";
        //split

        String[] words = sample.split(" ");
        //create treeMap
        TreeMap<String, Integer> counter = new TreeMap<>();
        //count
        for (String s : words) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
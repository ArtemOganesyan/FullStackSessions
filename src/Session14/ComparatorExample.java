package Session14;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 7, 9);

        Comparator<Integer> desc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Collections.sort(numbers, desc);

        System.out.println(numbers);
    }
}

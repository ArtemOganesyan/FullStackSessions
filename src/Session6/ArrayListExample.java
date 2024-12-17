package Session6;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        ArrayList<Integer> intArrayList = new ArrayList<>();
        intArrayList.add(43);
        intArrayList.add(12);
        System.out.println(intArrayList);
        intArrayList.add(33);
        System.out.println(intArrayList);
        intArrayList.remove(0);
        System.out.println(intArrayList);
        intArrayList.remove(Integer.valueOf(33));
        System.out.println(intArrayList);
    }
}

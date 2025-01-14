package Session15;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchExample {
    public static void main(String[] args) {
        // search for array[500]
        int[] array = new Random().ints(10000000, 1, 10000).toArray();
        int[] array2 = array;
        Arrays.sort(array2);

//        int[] ar = {4,5,1,3,7,0,9};
//        search(ar, 0);
        long startTime = System.nanoTime();
        search(array2, array[500]);
        long endTime = System.nanoTime();
        System.out.println("Time for binary: " + (endTime - startTime));

        long startTime2 = System.nanoTime();
        loopSearch(array, array[500]);
        long endTime2 = System.nanoTime();
        System.out.println("Time for loop: " + (endTime2 - startTime2));
    }

    private static boolean search(int[] array, int target) {
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        while(left<=right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) return true;
            else if (array[middle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return  false;
    }

    private static boolean loopSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }
}


// 4, 6, 7, 2, 0

// 0, 2, 4, 6, 7

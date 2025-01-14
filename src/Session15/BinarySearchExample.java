package Session15;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchExample {
    public static void main(String[] args) {
        // search for array[500]
        int[] array = new Random().ints(1000, 1, 10000).toArray();

        int[] ar = {4,5,1,3,7,0,9};
        search(ar, 0);
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
}


// 4, 6, 7, 2, 0

// 0, 2, 4, 6, 7

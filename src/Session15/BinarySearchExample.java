package Session15;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchExample {

    public static void main(String[] args) {
        int size = 1000000;
        int[] array = generateSortedArray(size);
        int target = array[new Random().nextInt(size)];

        // Measure O(n) - Linear Search
        long startTimeLinear = System.nanoTime();
        linearSearch(array, target);
        long endTimeLinear = System.nanoTime();
        System.out.println("O(n) Linear Search Time: " + (endTimeLinear - startTimeLinear) + " ns");

        // Measure O(log n) - Binary Search
        long startTimeBinary = System.nanoTime();
        binarySearch(array, target);
        long endTimeBinary = System.nanoTime();
        System.out.println("O(log n) Binary Search Time: " + (endTimeBinary - startTimeBinary) + " ns");
    }

    // Generate a sorted array of given size
    private static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    // Linear search O(n)
    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary search O(log n)
    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}


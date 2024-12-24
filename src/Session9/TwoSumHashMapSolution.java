package Session9;

import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMapSolution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                return new int[] {numMap.get(diff), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main(String[] args) {
//        int[] nums1 = {2,7,11,15};
//        int target = 9;
//        int[] result1 = twoSum(nums1, target);
//        System.out.println("Output: " +result1[0] + " " + result1[1]);

        int[] nums2 = {2,2,6,4,5,7,8,1};
        int target2 = 13;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Output: " + result2[0] + " " + result2[1]);
    }
}

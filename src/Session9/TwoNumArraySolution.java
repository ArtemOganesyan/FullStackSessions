package Session9;

public class TwoNumArraySolution {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
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

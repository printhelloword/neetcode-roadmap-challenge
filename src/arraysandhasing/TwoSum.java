package arraysandhasing;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 4, 8}, 12)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 8, 9, 5}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] twoSumIndices = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                if (i==j) continue;
                if ((nums[i] + nums[j]) == target) {
                    twoSumIndices[0] = i;
                    twoSumIndices[1] = j;
                    return twoSumIndices;
                }
            }
        }
        return null;
    }
}

package arraysandhasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(multiplyArray(nums, i));
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int multiplyArray(int[] nums, int index) {
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) continue;
            result *= nums[i];
        }
        return result;
    }

}

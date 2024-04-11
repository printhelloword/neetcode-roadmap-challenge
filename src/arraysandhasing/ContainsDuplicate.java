package arraysandhasing;

import java.util.ArrayList;
import java.util.List;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i]))
                return true;
            else
                temp.add(nums[i]);
        }
        return false;
    }
}

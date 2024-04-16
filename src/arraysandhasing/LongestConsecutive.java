package arraysandhasing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 8, 4, 6, 0, 1, 11, 10}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 8, 4, 6, 1, 11, 10}));
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
        System.out.println(longestConsecutive(new int[]{0, 0}));

    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 1;

        if (nums.length == 1)
            return 1;

        if (nums.length == 0)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                map.put(1, 1);
                continue;
            }
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] == nums[i - 1] + 1) {
                counter++;
                map.put(i, counter);
            } else {
                counter = 1;
                map.put(i, counter);
            }
        }
        List<Integer> sortedMapValues = map.values().stream().sorted().toList();
        return sortedMapValues.get(sortedMapValues.size() - 1);
    }
}

package arraysandhasing;

import java.util.HashMap;

public class TopKFrequentElement {
    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3, 3}, 2);
        topKFrequent(new int[]{5, 4, 6, 8, 7, 2, 8, 3, 4, 6, 5, 3, 2, 1, 2, 3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }
        System.out.println(map);

        return new int[]{1};
    }
}

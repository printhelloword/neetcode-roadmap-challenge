package arraysandhasing;

import java.util.Arrays;
import java.util.HashMap;

public class TopKFrequentElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3, 3, 2, 2, 2}, 3)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{5, 4, 6, 8, 7, 2, 8, 3, 4, 6, 5, 6, 3, 6, 2, 6, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        /* Sort Keys asc frequent */
        int[] keys = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < keys.length - 1; j++) {
                if (map.get(keys[j + 1]) > map.get(keys[j])) {
                    int temp = keys[j];
                    keys[j] = keys[j + 1];
                    keys[j + 1] = temp;
                }
            }
        }

        return Arrays.stream(keys).limit(k).toArray();
    }
}

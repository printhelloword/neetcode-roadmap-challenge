package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,2,4,6,8}, 6));
        System.out.println(search(new int[]{-1,0,2,4,6,8}, 3));
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
    
}

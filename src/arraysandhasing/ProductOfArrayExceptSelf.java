package arraysandhasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));

        System.out.println();

        System.out.println(Arrays.toString(productExceptSelfUsingPrefixPostfix(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelfUsingPrefixPostfix(new int[]{-1, 1, 0, -3, 3})));
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

    public static int[] productExceptSelfUsingPrefixPostfix(int[] nums) {
        int[] prefix  = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0]=1;
        postfix[nums.length-1]=1;
        int startPrefixPostfix = 1;

        for(int i=0; i < nums.length ; i++){
            if (i==0){
                prefix[i] = nums[i] * startPrefixPostfix;
            }else
                prefix[i] = nums[i] * prefix[i-1];
        }
        System.out.println("prefixes : " + Arrays.toString(prefix));

        for(int i=nums.length-1; i >= 0 ; i--){
            if (i==nums.length-1)
                postfix[i] = nums[i] * startPrefixPostfix;
            else
                postfix[i] = nums[i] * postfix[i+1];
        }
        System.out.println("postfixes : " + Arrays.toString(postfix));

        int[] result = new int[nums.length];
        for (int i = 0  ; i < nums.length; i++) {
            if (i==0)
                result[i] = postfix[i+1] * startPrefixPostfix;
            else if(i==nums.length-1)
                result[i] = prefix[i-1] * startPrefixPostfix;
            else
                result[i] = prefix[i-1] * postfix[i+1];
        }
        return result;
    }

}

package slidingwindow;

public class BuyAndSellCrypto {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{2,4,1}));
    }
    
    public static int maxProfit(int[] prices) {
        int lowerLowIndex = 0;
        int higherHighIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i==0) continue;
            if(prices[i] < prices[lowerLowIndex]){
                if (i+1 != prices.length){
                lowerLowIndex = i;
                higherHighIndex = i;}
            } 
            else if (prices[i] > prices[higherHighIndex])
                higherHighIndex = i;
        }

        int result;
        if (higherHighIndex == -1)
            result = 0;
        else 
            result = prices[higherHighIndex] - prices[lowerLowIndex];

        return result;
    }
}

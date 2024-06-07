package slidingwindow;

public class BuyAndSellCrypto {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{2,4,1}));
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }
    
    public static int maxProfit(int[] prices) {
        int lowerLowIndex = 0;
        int higherHighIndex = 0;
        int highestProfit=0;
        for (int i = 0; i < prices.length; i++) {
            int profit;
            if (i==0) continue;
            if(prices[i] < prices[lowerLowIndex]){
                if (i+1 != prices.length){
                lowerLowIndex = i;
                higherHighIndex = i;}
            } 
            else if (prices[i] > prices[higherHighIndex])
                higherHighIndex = i;

            if (higherHighIndex == -1)
                profit = 0;
            else 
                profit = prices[higherHighIndex] - prices[lowerLowIndex];
            
            if (profit>highestProfit){
                highestProfit=profit;
            }
        }     
        return highestProfit;
    }
}

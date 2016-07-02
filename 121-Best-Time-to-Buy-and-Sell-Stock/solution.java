/**
 * 121. Best Time to Buy and Sell Stock
 * 2 solutions
 */ 


// s1: brute force
// O(n^2), O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(result, prices[j] - prices[i]);
            }
        }
        return result;
    }
}
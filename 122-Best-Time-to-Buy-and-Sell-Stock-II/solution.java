/**
 * 122. Best Time to Buy and Sell Stock II
 * 
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

// s1: greedy
// O(n), O(1)

public class Solution {
    public int maxProfit(int[] prices) {
        // corner case
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        // this array means if contains i elements, then the max_profits[i] represent the max profit
        int[] max_profits = new int[prices.length];
        
        // find the first increase index
        int index = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            if (index[i + 1] > index[i]) {
                index = i + 1;
                break;
            }
        }
        
        // the prices array are descending
        if (index == -1) {
            return 0;
        }
        
        max_profits[index] = prices[index] - prices[index - 1];
        
        for (int i = index + 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max_profits[i] = max_profits[i - 1] + prices[i] - prices[i - 1];
            } else {
                max_profits[i] = max_profits[i - 1];
            }
        }
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i]);
        }
        return result;
    }
}
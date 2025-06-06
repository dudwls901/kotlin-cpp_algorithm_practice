//구현?슬라이딩윈도우?
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            }
        }
        return maxProfit;
    }
}

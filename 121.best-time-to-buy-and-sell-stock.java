/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
		int cost = Integer.MAX_VALUE, maxProfit=0;
        for(int i=0;i<prices.length;i++){
			if(prices[i]>cost){
				cost = prices[i];
			}
			else if(maxProfit<prices[i]-cost){
				maxProfit = prices[i]-cost;
			}
		}
		return maxProfit;
    }
}
// @lc code=end


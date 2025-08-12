/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
               int cursum = 0;
               int maxnum = nums[0];
               for(int i=0;i<nums.length;++i){
                                if(cursum<0) cursum=0;
                cursum+=nums[i];
                maxnum = Math.max(maxnum,cursum);
               }
               return maxnum;

    }
}
// @lc code=end


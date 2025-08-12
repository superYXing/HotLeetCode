/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(target<nums[mid]) j = mid-1;
            else if(target>nums[mid]) i = mid+1;
            else return mid;
        }
        return -1;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l<=r){
            int mid = (l+r)/2;
           if(nums[l]<=nums[mid]&&nums[r]>=nums[mid])
            return nums[l];
            else if(nums[mid]>=nums[l]) l = mid+1;
            else if (nums[mid]<=nums[r]) r = mid;
        }
        return -1;
    }
}
// @lc code=end


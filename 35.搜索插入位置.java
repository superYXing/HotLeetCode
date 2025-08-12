/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length -1;
        int m = 0;
        boolean flag = false;
        while (i<=j){
           m = (i+j)/2;
            if(nums[m]>target){
                j = m-1;
            }
            else if(nums[m]<target){
                i = m+1;
            }
            else {
                flag = true;
                break;
            }
        }
        if (flag) return m;
        else{
          for(i=0;i<nums.length;i++){
            if(nums[i]>target) break;
          }
        } 
        return i;
    }
}
// @lc code=end


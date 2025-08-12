/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int[] arr = {0,0};
        int candidate = -1;
        while(i<=j){
            
            int mid = (i+j)/2;

            if(nums[mid]>target){
              j = mid - 1;
            }else if(nums[mid]<target){
                
                i = mid+1;
            }else{

                candidate = mid;
                 
                i = mid + 1;
            }

        }
        arr[1] = candidate;
        candidate = -1;
        i=0;
        j=nums.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]>target){
              j = mid - 1;
            }else if(nums[mid]<target){
                
                i = mid+1;
            }else{
                candidate = mid;
                j = mid - 1;
            }
        }
        arr[0] = candidate;
        return arr;
    }
}
// @lc code=end


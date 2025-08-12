/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
            int[] L = new int[nums.length];
            int[] R = new int[nums.length];
            int[] temp = new int[nums.length];
            L[0] = 1;
            R[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++){
            L[i] = L[i-1] * nums[i-1];
        }
        for (int i = nums.length-2;i>=0;i--){
            R[i] = R[i+1] * nums[i+1];
        }
        for(int i = 0;i<nums.length;i++){
            System.out.println("L["+i+"]: "+L[i]+", R["+i+"]: "+R[i]);
            temp[i] = L[i] * R[i]; 
        }
        return temp;
    }
}
// @lc code=end


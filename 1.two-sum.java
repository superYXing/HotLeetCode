/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> hashmap = new HashMap<>();
	   for(int i=0;i<nums.length;i++){
			int n = target - nums[i];
			if (hashmap.containsKey(n)) return new int[] {hashmap.get(n),i};  
			else{
				hashmap.put(nums[i], i);
			}
	   }
	   return null;
    }
}
// @lc code=end


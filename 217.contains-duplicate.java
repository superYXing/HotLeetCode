/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
		/* HashMap实现（比HashSet多调用一行put，慢，15ms） */

		/* 
        HashMap<Integer,Integer> map = new HashMap<>();
		for (int i : nums) {
			if(map.containsKey(i)) return true;
			map.put(i,i);
		}
		return false;
		*/

		//HashSet实现, 10ms , 优势在于只需一行add()
		HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			if(!set.add(i)) return true;
		}
		return false;
    }
}
// @lc code=end


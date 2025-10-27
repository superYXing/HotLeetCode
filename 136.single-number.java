/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */
import java.util.HashSet;
// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {

		//哈希map的解法
		/* 
        HashSet<Integer> set = new HashSet<>();
		for(int i : nums){
			if(!set.add(i)) set.remove(i);	
		}
		Object[] res = set.toArray();
		return (int)res[0];
		*/

		//异或解法
		int res = 0;
		for (int i : nums) {
			res^=i;
		}
		return res;
    }
}
// @lc code=end


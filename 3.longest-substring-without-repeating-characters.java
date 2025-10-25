/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
		int begin = 0;
		int max = 0;
		for(int end = 0; end<s.length();end++){
			char ch = s.charAt(end);
			if(map.containsKey(ch)){
				begin = map.get(ch)>=begin?map.get(ch)+1:begin;
				map.put(ch, end);
			}else{
				map.put(ch,end);
			}
			max = max>end-begin+1?max:end-begin+1;

		}
		return max;
    }
}
// @lc code=end


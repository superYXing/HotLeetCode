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
		for(int end = 0; end<s.length();end++){
			char ch = s.charAt(end);
			if(map.containsKey(ch)){
				begin = map.get(ch)+1>=begin+1?map.get(ch)+1:begin+1;
				map.put(ch, end);
			}else{
				map.put(ch,end);
			}
			for(int i = begin ; i<=end ; i++){
				System.out.println(s.charAt(i));
			}
		}
    }
}
// @lc code=end


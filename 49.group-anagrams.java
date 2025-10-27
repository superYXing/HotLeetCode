/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String,List<String>> map = new HashMap<>();

		for(String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);
			List<String> l = map.get(key);
			if(l==null){
				l = new ArrayList<>();
				map.put(key, l);
			}
			l.add(str);
    }

		
	return new ArrayList<>(map.values());
}
}
// @lc code=end


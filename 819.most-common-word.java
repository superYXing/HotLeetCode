/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map = new HashMap<>();
		String[] st = paragraph.toLowerCase().split("[^A-Za-z]+");
		boolean flag = false;
		for(String s : st){
			for(String t:banned){
				if(s.equals(t)){
					flag = true;
					break;
				} 
			}
			if(!flag){
			Integer value = map.get(s);
			if(value==null) value=0;
			map.put(s, ++value);
			}else{
				flag = false;
			}
		}		
		int max = 0;
		String maxKey = null;
		for(HashMap.Entry<String,Integer> e: map.entrySet()){
			if(e.getValue()>max){
				max = e.getValue();
				maxKey = e.getKey();
			}
		}
		return maxKey;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {

		//暴力法双循环 16ms
		/* 
		char[] ch = s.toCharArray();
        
        if(ch.length == 1 ) return 0;
		for(int i =0 ; i< ch.length ; i++){
			char c = ch[i];
			for(int j = 0 ; j<ch.length; j++){
                if(j == i) continue;
                if(c == ch[j]) break;
				if(j == ch.length-1) return i;
                if(i==ch.length-1){
                    if(j == ch.length-2) return i;
                }
			}

		}
		return -1;
		*/

		// bitMap 6ms
		int[] times = new int[26];
		for(int i=0; i<s.length();i++){
			char ch = s.charAt(i);
			times[ch-'a']++;
		}
		int j = 0;
		for(char i : s.toCharArray()){
			if(times[i-'a'] == 1) return j;
			j++;
		}
		return -1;
    }
}
// @lc code=end


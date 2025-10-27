/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

		//使用字符数组排序后比较
		/* 
        char[] ch1 = s.toCharArray();
		char[] ch2 = t.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		return Arrays.equals(ch1, ch2);
		*/

		//使用bitMap
		return Arrays.equals(getKey(s), getKey(t));

    }

	static int[] getKey(String s){
		int[] array = new int[26];
		char[] ch = s.toCharArray();
		for (char c : ch) {
			array[c-'a'] += 1;
		}
		return array;
	}
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if (c == '(') {
    stack.add(')');
}
else if (c == '{') {
    stack.add('}');
}
else if (c == '[') {
    stack.add(']');
}
            else {
                if(!stack.isEmpty()&&stack.peek()==c){
                    stack.pop();
                }else return false;
            } 
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
// @lc code=end


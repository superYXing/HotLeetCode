/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(String s : tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                    int b = stack.pop();
                    int a = stack.pop();
                
                if(s.equals("+")){
                    res = a+b; 
                }else if(s.equals("-")) {
                    res = a-b;
                }else if(s.equals("*")){
                    res = a*b;
                }else if(s.equals("/")){
                    res = a/b;
                }
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(s));
            }
            
        }
          return stack.pop();
    }
      
}
// @lc code=end


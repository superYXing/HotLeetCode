/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack1.empty()) stack2.push(stack1.pop());
        stack2.push(x);
    }
    
    public int pop() {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }
    
    public int peek() {
        while(!stack2.isEmpty()){
        stack1.push(stack2.pop());
        }
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end


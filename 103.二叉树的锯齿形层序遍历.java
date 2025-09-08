/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.LinkedList;




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
         if(root!=null) deque.addFirst(root);
         else return res;
        boolean Odd = true;
        
        while(!deque.isEmpty()){
            int num = deque.size();
            LinkedList l = new LinkedList<>();
            
            for(int i=0;i<num;i++){
                TreeNode t = deque.pollFirst();
                if(t.left!=null) deque.add(t.left);
                if(t.right!=null) deque.add(t.right);
                if(Odd){
                    l.offerLast(t.val);
                }else{
                    l.offerFirst(t.val);
                }
            }
            res.add(l);
            Odd = !Odd;
        }
        return res;
    }
    
}
// @lc code=end


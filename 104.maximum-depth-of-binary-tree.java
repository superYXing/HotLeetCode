/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
    public int maxDepth(TreeNode root) {
        //递归法
        // if(root==null) return 0;
        // if(root.left==null&&root.right==null) return 1;
        // int d1 = maxDepth(root.left);
        // int d2 = maxDepth(root.right);
        // return Integer.max(d1,d2)+1;

        //后序遍历
// LinkedList<TreeNode> stack = new LinkedList<>();
//         TreeNode curr = root;
//         TreeNode pop = null;
//         int max = 0;
//         while(!stack.isEmpty()||curr!=null){
            
//             if(curr!=null){
//                 stack.push(curr);
//                 int size = stack.size();
//                 max = size>max?size:max;
//                 curr=curr.left;
//             } 
//             else{
//                 TreeNode peek = stack.peek();
//                 if(peek.right==null||peek.right==pop){
//                     pop = stack.pop();
//                 }else{
//                     curr = peek.right;
//                 }
//             }
//         }
//         return max;

        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return 0;
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }
}
// @lc code=end


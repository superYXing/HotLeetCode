/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start

import java.util.Stack;

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
    public boolean isValidBST(TreeNode root) {
		/* 中序遍历 
        TreeNode curr = root;
		TreeNode prev = null;
		Stack<TreeNode> stack = new Stack<>();
		while(curr!=null || !stack.isEmpty()){
			if(curr!=null){
				prev = curr;
				stack.add(curr);
				curr = curr.left;
			}else{
				TreeNode pop = stack.pop();
				//do something
				if(prev.val>pop.val) return false;
				if(pop.right!=null) curr = pop.right;
			}
		}
		return true;
		*/

		//上下界法
		return doValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	private boolean doValid(TreeNode node, long min, long max){
		if(node == null) return true;
		if(node.val<min || node.val>max) return false;
		return doValid(node.left, min, node.val) && doValid(node.right, node.val, max);
	}
		
}
// @lc code=end


/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
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
    public int rangeSumBST(TreeNode root, int low, int high) {
		/* 
        TreeNode Leftnode = root;
		TreeNode Rightnode = root.right;
		ArrayList<Integer> array = new ArrayList<>();
		while(Leftnode!=null){
			if(Leftnode.val>=low&&Leftnode.val<=high){
				array.add(Leftnode.val);
				Leftnode = Leftnode.left;
			}else if(Leftnode.val<low){
				Leftnode = Leftnode.right;
			}else{
				Leftnode = Leftnode.left;
			}
		}
			while(Rightnode!=null){
			if(Rightnode.val>=low&&Rightnode.val<=high){
				array.add(Leftnode.val);
				Leftnode = Leftnode.left;
			}else if(Leftnode.val<low){
				Leftnode = Leftnode.right;
			}else{
				Leftnode = Leftnode.left;
			}
				
		} */
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		ArrayList<Integer> array = new ArrayList<>();
		while(node!=null || !stack.isEmpty()){
			if(node!=null){
				stack.add(node);
				node = node.left;
			}else{
				TreeNode pop = stack.pop();
				if(pop.val>=low&&pop.val<=high) array.add(pop.val);
				node = pop.right;
			}
		}
		int sum = 0;
		for(int i=0;i<array.size();i++){
			sum+=array.get(i);
		}
		return sum;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
 */

// @lc code=start

  //Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
		/* 
        if(root.val<val){
			if(root.right!=null) insertIntoBST(root.right, val);
			else{
				root.right = new TreeNode(val);
				return root;
			} 
		} 
		else{
			if(root.left!=null) insertIntoBST(root.left, val);
			else{
				root.left = new TreeNode(val);
				return root;
			} 
		}
		*/
		
		if(root==null) return new TreeNode(val);
		if(root.val<val) root.right = insertIntoBST(root.right, val);
		else if(root.val>val) root.left = insertIntoBST(root.left, val);
		return root;
    }
}
// @lc code=end


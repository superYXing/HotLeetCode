/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 */

// @lc code=start
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
    public TreeNode deleteNode(TreeNode root, int key) {
        //先根据key找到待删除结点
		TreeNode curr = root;
		TreeNode parent = null;
		while(curr!=null){
			if(curr.val>key){
				parent = curr;
				curr = curr.left;
			} 
			else if(curr.val<key){
				parent = curr;
				curr = curr.right;
			} 
			else break;
		}
		//没找到结点
		if(curr==null) return root;
		else{
			//如果只有左子树或者右子树，直接调用shift方法
			if(curr.left==null){
				root = shift(parent, curr, curr.right,root);
			}else if(curr.right==null){
				root = shift(parent,curr,curr.left,root);
			}else{
				//左右子树都存在的情况
				//先找到后继结点,在此情况下只可能是找右子树的最小值（不需要考虑祖先自左而来）
				TreeNode sucNode = curr.right;
				TreeNode p = curr;
				while(sucNode.left!=null){
					p =sucNode;
					sucNode = sucNode.left;
				}
				//判断后继和待删除结点是否相邻
				if(p!=curr){
					//不相邻，则先托孤
					root = shift(p, sucNode, sucNode.right, root);
					sucNode.right = curr.right;
				}
				//最后统一删除结点
				root = shift(parent, curr, sucNode, root);
				sucNode.left = curr.left;
			}
		}
		return root;
    }

	public TreeNode shift(TreeNode parent, TreeNode deleted, TreeNode child, TreeNode root){
		if (parent == null) return child;
		else{
		if(parent.right==deleted){
			parent.right = child;
		}else{
			parent.left = child;
		}
	}
    return root;
	}
}
// @lc code=end


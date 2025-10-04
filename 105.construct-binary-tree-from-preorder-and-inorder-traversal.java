/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start

import java.util.Arrays;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        for(int i = 0 ; i < inorder.length ; i++){
            if(inorder[i]==rootVal){
               int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
               int[] inRight = Arrays.copyOfRange(inorder, i+1, inorder.length);

               int[] preLeft = Arrays.copyOfRange(preorder, 1, i+1);
               int[] preRight = Arrays.copyOfRange(preorder, i+1, preorder.length);

               root.left = buildTree(preLeft, inLeft);
               root.right = buildTree(preRight,inRight);
               break;
            }
        }
        return root;
    }
}
// @lc code=end


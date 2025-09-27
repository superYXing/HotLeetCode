/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while(!leftQueue.isEmpty()&&!rightQueue.isEmpty()){

            TreeNode leftTemp = leftQueue.poll();
            TreeNode rightTemp = rightQueue.poll();

            if (leftTemp == null && rightTemp == null) continue;
            if (leftTemp == null || rightTemp == null) return false;
            if (leftTemp.val != rightTemp.val) return false;

            leftQueue.add(leftTemp.left);
            leftQueue.add(leftTemp.right);

            rightQueue.add(rightTemp.right);
            rightQueue.add(rightTemp.left);
        }
        return true;
    }
    
}
// @lc code=end


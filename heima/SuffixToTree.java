package heima;

import java.util.Stack;

public class SuffixToTree {
    static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

       public TreeNode(String val){
        this.val = val;
       } 
       public TreeNode(TreeNode left, String val, TreeNode right){
        this.left = left;
        this.val = val;
        this.right = right;
       }
    }

    static TreeNode constructExpressionTree(String[] tokens){
        Stack<TreeNode> stack = new Stack<>();
        for (String t : tokens) {
            switch (t) {
                case "+","-","*","/":
                    TreeNode parent = new TreeNode(t);
                    parent.right = stack.pop();
                    parent.left = stack.pop(); 
                    stack.push(parent);
                    break;
            
                default:
                    stack.push(new TreeNode(t));
            }
        }
        return stack.peek();
    }

    static void RecursionTree(TreeNode root){
        if(root==null) return;
        
        RecursionTree(root.left);
        
        RecursionTree(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        String[] tokens = {"21","5","-","3","*"};
        TreeNode root = constructExpressionTree(tokens);
        RecursionTree(root);
    }
}

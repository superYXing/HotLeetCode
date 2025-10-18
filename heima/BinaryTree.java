package heima;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }
        public TreeNode(TreeNode left,int value,TreeNode right){
            this.value=value;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode node = new TreeNode(
        new TreeNode(
            new TreeNode(null,4,null),2,null)  
             , 1 ,
              new TreeNode(
                new TreeNode(null,5,null),3,new TreeNode(
                    null,6,null)));
    
    
    public BinaryTree(){
      
    }

    public void LevelOrder(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left!=null)
            queue.add(temp.left);
            if(temp.right!=null)
            queue.add(temp.right);
            System.out.println(temp.value);
        }

    }

    public void PreOrder(TreeNode node){
        if(node==null) return;
        System.out.println(node.value);
        PreOrder(node.left);
        PreOrder(node.right);
    }

    public void MidOrder(TreeNode node){
        if(node==null) return;
        MidOrder(node.left);
        System.out.println(node.value);
        MidOrder(node.right);
    }

    public void LastOrder(TreeNode node){
        if(node==null) return;
        LastOrder(node.left);
        LastOrder(node.right);
        System.out.println(node.value);
    }
/*
 * 非递归前序遍历
 */
    public void PreOrderWithNoRecursion(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        
        while( curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                System.out.println("去："+curr.value);
                curr = curr.left;
            }else{
                curr = stack.pop();
                curr = curr.right;
            }
        } 
    }

    public void MidOrderWithNoRecursion(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        
        while( curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                System.out.println("中序："+curr.value);
                curr = curr.right;
            }
        } 
    }
    public void LastOrderWithNoRecursion(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        TreeNode pop = null;
        while( curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right==null || peek.right == pop){
                    pop = stack.pop();
                    System.out.println("后续："+pop.value);
                }else{
                    curr = peek.right;
                }   
            }
        } 
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
         tree.LastOrderWithNoRecursion(tree.node);
    }
}

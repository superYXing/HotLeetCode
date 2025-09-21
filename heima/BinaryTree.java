package heima;

import java.util.LinkedList;
import java.util.Queue;

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
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.LastOrder(tree.node);
    }
}

package heima;

import java.util.LinkedList;
import java.util.Queue;

public class testForTreeRecursion {
 static class TreeNode {
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
  TreeNode root=null;
  public testForTreeRecursion(){
	root = new TreeNode(8,new TreeNode(5,new TreeNode(4,null,null),new TreeNode(7,null,null)),
	new TreeNode(18,new TreeNode(10,null,null),new TreeNode(20,null,null)));
  }
  public TreeNode insertIntoBST(TreeNode root, int val) {	
		if(root==null) return new TreeNode(val);
		if(root.val<val) root.right = insertIntoBST(root.right, val);
		else if(root.val>val) root.left = insertIntoBST(root.left, val);
		return root;`
    }
public void LevelOrder(){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            System.out.println(temp.val);
        }

    }
    
	public static void main(String[] args) {
		testForTreeRecursion test = new testForTreeRecursion();
		test.insertIntoBST(test.root, 6);
		test.LevelOrder();
	}
}

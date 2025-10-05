package heima;
public class BinarySearchTree {
    BSTNode root;
    static class BSTNode{
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key,Object value,BSTNode left,BSTNode right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode(){}

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        
    }

    public Object get(int key){
        return DoGet(root, key);
    }

    private Object DoGet(BSTNode root, int key){
        
        BSTNode curr = root;
        while(curr!=null){
            if(curr.key>key) curr = curr.left;
            else if (curr.key<key) curr = curr.right;
            else break;
        }
        if(curr == null) return null;
        else return curr.value;
    }

    public BinarySearchTree(){
        root = new BSTNode(4,4,new BSTNode(2,2,new BSTNode(1,1,null,null),new BSTNode(3,3,null,null
        )),new BSTNode(7,7,new BSTNode(6,6,new BSTNode(5,5,null,null),null),new BSTNode(8,8,null,null)));
    }

    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree();
        int val = (int)root.get(10);
        System.out.println(val);
    }
}

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
            else return curr.value;
        }
        return null;
        
    }
    public void put(int key,Object value){
        if(root!=null) {
        BSTNode curr = root;
        BSTNode parent = new BSTNode();
        while(curr!=null){
            parent = curr;
            if(curr.key>key) curr = curr.left;
            else if (curr.key<key) curr = curr.right;
            else {
                curr.value = value;
                return;
            }
        }
        if(key>parent.key) parent.right = new BSTNode(key,value);
        else parent.left = new BSTNode(key,value);
    }else{
        BSTNode n = new BSTNode(key,value);
        root = n;
    }
    return;
    }
    public Object min(){
        if(root == null) return null;
        BSTNode node = root;
        while(node.left!=null){
            node = node.left;
        }
        return node.value;
    }

    public Object max(){
        if(root == null) return null;
        BSTNode node = root;
        while(node.right!=null){
            node = node.right;
        }
        return node.value;
    }
    public BinarySearchTree(){
        root = new BSTNode(4,4,new BSTNode(2,2,new BSTNode(1,1,null,null),new BSTNode(3,3,null,null
        )),new BSTNode(7,56,new BSTNode(6,6,new BSTNode(5,5,null,null),null),new BSTNode(8,8,null,null)));
    }


    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree();
//         Object val = root.get(72);
//         // 先判断是否为null，是则打印null
// if (val == null) {
//     System.out.println(val);
// } 
// // 非null时判断是否为Integer类型，是则输出
// else if (val instanceof Integer) {
//     System.out.println(val);
// }
    root.put(4, 100);
    int val = (int)root.get(4);
    System.out.println(val);
    }
}

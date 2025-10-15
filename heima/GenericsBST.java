package heima;
public class GenericsBST<T extends Comparable<T>,V> {
    BSTNode<T,V> root;
    static class BSTNode<T extends Comparable<T>,V>{
        T key;
        V value;
        BSTNode<T,V> left;
        BSTNode<T,V> right;

        public BSTNode(T key,V value,BSTNode<T,V> left,BSTNode<T,V> right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
        public BSTNode(){}

        public BSTNode(T key, V value) {
            this.key = key;
            this.value = value;
        }

        
    }
    
    public Object get(T key){
        return DoGet(root, key);
    }

    private Object DoGet(BSTNode<T,V> root, T key){
        
        BSTNode<T,V> curr = root;
        while(curr!=null){
            int result = key.compareTo(curr.key);
            if(result<0) curr = curr.left;
            else if (result>0) curr = curr.right;
            else return curr.value;
        }
        return null;
        
    }
    @SuppressWarnings("unchecked")
    public GenericsBST (){
        root = new BSTNode(4,4,new BSTNode(2,2,new BSTNode(1,1,null,null),new BSTNode(3,3,null,null
        )),new BSTNode(7,56,new BSTNode(6,6,new BSTNode(5,5,null,null),null),new BSTNode(8,8,null,null)));
    }

    public static void main(String[] args) {
        GenericsBST<Integer,Integer> root = new GenericsBST<>();
        Object val = root.get(4);
        // 先判断是否为null，是则打印null
if (val == null) {
    System.out.println(val);
} 
// 非null时判断是否为Integer类型，是则输出
else if (val instanceof Integer) {
    System.out.println(val);
}
    }
}

package heima;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
        return doMin(root);
    }
    private Object doMin(BSTNode n){
         BSTNode node = n;
                if(node==null) return null;
               
                while(node.left!=null){
                    node = node.left;
                }
                return node.value; 
    }
    public Object max(){
        return doMax(root);
    }
    private Object doMax(BSTNode n){ 
        BSTNode node = n;
                if(node==null) return null;
               
                while(node.right!=null){
                    node = node.right;
                }
                return node.value; 
            }  
    public BinarySearchTree(){
        root = new BSTNode(4,4,new BSTNode(2,2,new BSTNode(1,1,null,null),new BSTNode(3,3,null,null
        )),new BSTNode(7,7,new BSTNode(6,6,new BSTNode(5,5,null,null),null),new BSTNode(8,8,null,null)));
    }

    public Object predecessor(int key){
        BSTNode node = root;
        BSTNode predecNode = new BSTNode();
        while(node!=null){
            if(node.key>key) node = node.left;
            else if(node.key<key){
                predecNode = node;
                node = node.right;
            } 
            else break;
        }
        
        if(node==null) return null;
        else{
            if(node.left!=null){
                //找左子树的最大值
                BSTNode temp = node.left;
                int val = (int)doMax(temp);
                return val;              
            }else{
                return predecNode==null?null:predecNode.value;
            }
        }
    }

    public Object successor(int key){
        BSTNode node =root;
        BSTNode sucNode = new BSTNode();
        while(node!=null){
            if(node.key>key){
                sucNode = node;
                node = node.left;
                
            }else if(node.key<key){
                node = node.right;
            }else{
                break;
            }
        }
        if(node==null) return null;
        else{
            if(node.right!=null){
                int val = (int)doMin(node.right);
                return val;
            }else{
                return sucNode==null?null:sucNode.value;
            }
        }
    }

    public Object delete(int key){
        BSTNode node = root;
        BSTNode parent = new BSTNode();
        while(node!=null){
            if(node.key>key){
                parent = node;
                node = node.left;
            }else if(node.key<key){
                parent = node.right;
                node = node.right;
            }else break;
            } 
        if(node==null) return null;
        else{
        if(node.left == null){
            shift(node,parent,node.right);
        }else if(node.right == null){
            shift(node,parent,node.left);
        }else{
			//后继结点
			BSTNode s = node;
			//后继结点的父亲
			BSTNode sparent = null;
			// 先找待删除结点node的后继s以及sparent
			while(s.left!=null){
				sparent = s;
				s=s.left;
			}
			//判断待删除结点和后继结点是否相邻
			if(sparent!=node){
				//如果不相邻，则处理后继结点的后事
				shift(sparent, s, s.right);
				s.right = node.right;
			}

			//最后统一删除目标结点
			shift(parent, node, s);
			s.left = node.left;
        }
    }
	return node.value;
}
        private void shift(BSTNode deleted, BSTNode parent, BSTNode child){
            if(parent==null) root = parent;
            else{
                if(parent.left==deleted){
                    //托孤在左子树
                    parent.left=child;
                }else if(parent.right==deleted){
                    //托孤在右子树
                    parent.right = child;
                }
            }
        }

		public List<Object> less(int key){
			BSTNode curr = root;
			Stack<BSTNode> stack = new Stack<>();
			LinkedList<Object> res = new LinkedList<>();
			while(curr!=null||!stack.isEmpty()){
				if(curr!=null){
					stack.push(curr);
					curr = curr.left;
				}else{
					BSTNode n = stack.pop();
					if(key>n.key){
						res.add(n.key);
					}
					curr = n.right;
				}
			}
			return res;
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
//     Object res = root.successor(8);
//     if(res instanceof Integer)
//    System.out.println(res);
//    else{System.out.println("null");}
List<Object> list = new LinkedList<>();
list = root.less(6);
System.out.println(list.toString());
    }
}

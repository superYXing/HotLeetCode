package heima;

public class DoubleLinkedListSentinel {

    private static class Node {
        private Node prev;
        private int value;
        private Node next;

        public Node(Node prev,int value,Node next){
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

    }
    private Node head;
    private Node tail;

    public DoubleLinkedListSentinel(){
        head = new Node(null, 666, null);  // 头节点的next指向tail
        tail = new Node(head, 888, null);    // 尾节点的prev指向head
        head.next = tail;
    }

    public Node findNode(int index){
        //头哨兵是-1
        int i = -1;
        Node p = head;
        while(p!=null){
            if(i == index) return p;
            p = p.next;
            i++;
        }
        return null;
    }

    public int get(int index){
        Node p = findNode(index);
        return p.value;
    }

    public void insert(int value,int index){
        Node prev = findNode(index-1);
        if(prev==null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        Node p = new Node(prev,value,prev.next);
        prev.next.prev = p;
        prev.next = p;
    }

    public void whileLoop(){
        //带有哨兵，从哨兵的下一个结点开始便利
        Node p = head.next;
        while(p!=tail){
            System.out.println(p.value);
            p = p.next;
        }
    }

    public void remove(int index){
        Node prev = findNode(index-1);
        Node after = findNode(index+1);
        
        if(prev==null||after==null)  throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        prev.next = after;
        after.prev = prev;
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        Node p = head;
        int i=-1;
        while(p.next!=tail){
            p = p.next;
            i++;
        }
        remove(i);
    }
    public void addFirst(int value){
        insert(value, 0);
    }
    public void addLast(int value){
        Node p = head;
        int i=-1;
        while(p.next!=null){
            p = p.next;
            i++;
        }
        insert(value, i);
    }

    public void recursion(Node curr){
        System.out.println("before:"+curr.value);
        if(curr.next!=tail)
        recursion(curr.next);
        System.out.println("after:"+curr.value);
    }
    public void recursionWithHead(){
        recursion(head.next);
    }
    public static void main(String[] args) {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        // list.insert(1, 0);
        // list.insert(2, 1);
        // list.insert(3, 2);
        // list.insert(4, 3);

        list.addFirst(1);
        
        list.addFirst(2);
        
        list.addFirst(3);

        list.addLast(55);

        list.remove(3);
        list.recursionWithHead();
        
    }
}

package heima;

//哨兵节点单向链表
public class SinglyLinkedListSentinel {

 private Node head = new Node(666,null);

    private static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        
    }

    public void addFirst(int value){
        //引入哨兵结点后，直接调用insert方法
        insert(0, value);
        // head = new Node(value,head);
    }

    public void whileLoop(){
        //使用哨兵的后一个结点开始遍历
        Node p = head.next;
        while(p!=null){
            System.out.println(p.value+"指针： "+p);
            p = p.next;
        }
    }

    public Node findLast(){
        // if(head == null) return null;
        Node p = head;
        while(p.next!=null)
        p = p.next;
        return p;
    }

    public void addLast(int value){

       Node p = findLast();
    //    if(p==null){
    //      addFirst(value);
    //    }
       Node insert = new Node(value,null);
       p.next = insert;
       

    }


    public void addlast(int first,int[] rest){
        addLast(first);
        for (int value:rest){
            addLast(value);
        }
    }

    public int get(int index){
        Node p = findNode(index);
        // if(p == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        return p.value;
    }

    private Node findNode(int index){
        //***哨兵的起始索引，改为-1***
        int i = -1;
        //令哨兵结点的索引为-1
        Node p = head;
        while(p!=null){

            if(i==index) return p;
            p = p.next;
            i++;
        }
                
        return null;
    }
    
    public void insert(int index,int value){

        int pos = index - 1 ;
        Node p = findNode(pos);
        if(p == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        Node a = new Node(value,p.next);
        p.next = a;

    }

    public void removeFirst(){
             //引入哨兵结点后，直接调用remove方法
             remove(0);
        // head = head.next;
    }

    public void remove(int index){
        //引入哨兵节点后，不需要判断索引为0
        // if(index == 0){
        //     removeFirst();
        // }
        Node prev = findNode(index - 1);
        if(prev == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        if(prev.next == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        prev.next = prev.next.next;
        
    }
    
    public static void main(String[] args){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        // list.addFirst(3);
        // list.addFirst(2);
        // list.addFirst(1);
        list.addLast(4);
        int[] arr = {2,3,5};
        list.addlast(1,arr);
        list.whileLoop();
        System.out.println(list.get(2));


        list.insert(2,9989);
        System.out.println("after insert");
        list.whileLoop();

//              list.removeFirst();
//   System.out.println("after removeFirst"); 
//         list.whileLoop();

        // list.remove(-1);
        //   System.out.println("after removeIndex"); 
        //           list.whileLoop();

    }
}

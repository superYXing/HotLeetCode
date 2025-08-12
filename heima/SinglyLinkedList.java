package heima;
import java.lang.IllegalArgumentException;
public class SinglyLinkedList {

    private Node head = null;

    private static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        
    }

    public void addFirst(int value){
        head = new Node(value,head);
    }

    public void whileLoop(){
        Node p = head;
        while(p!=null){
            System.out.println(p.value+"指针： "+p);
            p = p.next;
        }
    }

    public Node findLast(){
        if(head == null) return null;
        Node p = head;
        while(p.next!=null)
        p = p.next;
        return p;
    }

    public void addLast(int value){

       Node p = findLast();
       if(p==null){
        // System.out.println("here");
         addFirst(value);
       }
       else{
       Node insert = new Node(value,null);
       p.next = insert;
       }

    }


    public void addlast(int first,int[] rest){
        addLast(first);
        for (int value:rest){
            addLast(value);
        }
    }

    public int get(int index){
        Node p = findNode(index);
        if(p == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        return p.value;
    }

    private Node findNode(int index){
        int i = 0;
        Node p = head;
        while(i<index){
            p = p.next;
            if(p==null) return null;
            i++;
        }
                
        return p;
    }
    
    public void insert(int index,int value){
        if(index > 0){
        int pos = index - 1 ;
        Node p = findNode(pos);
        if(p == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        Node a = new Node(value,p.next);
        p.next = a;
        }else{
            addFirst(value);
        }
    }

    public void removeFirst(){
        head = head.next;
    }

    public void remove(int index){
        if(index == 0){
            removeFirst();
        }
        Node prev = findNode(index - 1);
        if(prev == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        if(prev.next == null) throw new IllegalArgumentException(String.format("Index[%d]不合法", index));
        prev.next = prev.next.next;
        
    }

    public int removeLast(){
        Node p = head;
        Node prev = null;
        if(head==null) throw new IllegalArgumentException("空");
        while(p.next!=null){
        prev = p;
        p = p.next;
        }
        int value;
        if(p==head){
            value = head.value;
            head=null;
        } 
        else {
        value = p.value;
        prev.next = null;
            return value;
    }
        return value;
    }
    public void reverse(){
        Node curr = head;
        Node prev = null;

        while(curr!=null){
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            if(nextTemp==null)  head = curr;
            curr = nextTemp;
        }

    }
    
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        // list.addFirst(3);
        // list.addFirst(2);
        // list.addFirst(1);
        // list.addLast(1);
        // int[] arr = {3,4};
        // list.addlast(2,arr);
        // list.whileLoop();
        // System.out.println(list.get(2));
        // System.out.println(list.findNode(1));

        // list.insert(1,2);
        System.out.println("after insert");
        list.whileLoop();

//              list.removeFirst();
//   System.out.println("after removeFirst"); 
//         list.whileLoop();

//         list.remove(5);
//           System.out.println("after removeIndex"); 
//                   list.whileLoop();
        // list.reverse();
        //  System.out.println("after reverse");
        //   list.whileLoop();

        System.out.println(list.removeLast());
         list.whileLoop();
    }

}

package heima;


public class LinkedListQueue<E> implements Queue<E> {

    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value,Node<E> next){
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null,null);
    private Node<E> tail = head;
    private int capacity =  10;
    private int size = 0;

    public LinkedListQueue(){
        tail.next = head;
    }

    @Override
    public boolean isEmpty() {
        if(head == tail) return true;
        return false;
    }

    @Override
    public boolean offer(E value) {
        if(!isFull()){
        Node<E> n = new Node<E>(value, head);
        tail.next = n;
        tail = n;
        size++;
        return true;
        }else 
        return false;
    }

    @Override
    public E peek() {
    if(isEmpty()) return null;
    return head.next.value;

    }

    @Override
    public E poll() {
        if(isEmpty()) return null;
        if(head.next==tail) tail = head;
        E value = head.next.value;
        head.next = head.next.next;
        size--;
        // head = head.next;
       
        return value;
    }

    public boolean isFull(){
        if(size==capacity) return true;
        return false;
    }
    

}

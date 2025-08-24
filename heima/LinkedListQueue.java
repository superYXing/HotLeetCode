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
        Node<E> n = new Node<E>(value, head);
        tail.next = n;
        tail = n;
        return true;
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
        // head = head.next;
       
        return value;
    }
    

}

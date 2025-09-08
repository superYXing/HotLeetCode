package heima;

public class DqueueLinkedList<E> implements Dqueue<E> {

    public static class Node<E>{
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev,E value,Node<E> next){
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    Node<E> sentinel = new Node<E>(null, null, null);
    int size;
    int capacity;
    public DqueueLinkedList(int capacity){
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        this.capacity = capacity;
    }
    @Override
    public boolean OfferFirst(E value) {
        if(isFull()) return false;
        size++;
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<E>(a, value, b);
        a.next = added;
        b.prev = added;
        return true;
        
    }

    @Override
    public boolean OfferLast(E value) {
        if(isFull()) return false;
        size++;
        Node<E> a = sentinel.prev;
        Node<E> b =sentinel;
        Node<E> added = new Node<E>(a, value, b);
        a.next = added;
        b.prev = added;
        return true;
        
    }

    @Override
    public boolean isEmpty() {
        
        return size==0;
    }

    @Override
    public boolean isFull() {
        
        return size==capacity;
    }

    @Override
    public E peekFirst() {
        
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        
        return sentinel.prev.value;
    }

    @Override
    public E pollFirst() {
        E value = sentinel.next.value;
        size--;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return value;
    }

    @Override
    public E pollLast() {
        E value = sentinel.prev.value;
        size--;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return value;
    }
    
    public void loop(){
        for(Node<E> n = sentinel;n.next!=sentinel;n=n.next){
            System.out.println(n.next.value);
        }
    }

}

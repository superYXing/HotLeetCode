package heima;

public class LinkedListStack<E> implements Stack<E>{

    private int capacity;
    private int size;
    private static class ListNode<E>{
        ListNode<E> next;
        E value;
        public ListNode(E value, ListNode<E> node){
            this.value = value;
            this.next = node;
        }
        public ListNode(){
        }
    }
    ListNode<E> head = new ListNode<>(null, null);
    public LinkedListStack(int capacity){
        this.capacity = capacity;
        this.size = 0;
    }
    @Override
    public boolean isEmpty() {
        if(size==0) return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if(size==capacity) return true;
        return false;
    }

    @Override
    public boolean offer(E value) {
        if(isFull()) return false;
        ListNode<E> node = new ListNode<>(value,head.next);
        head.next = node;
        size++;
        return true;
    }

    @Override
    public E peek() {
        return head.next.value;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = head.next.value;
        head.next = head.next.next;
        size--;
        return value;
    }

    public void loop(){
        ListNode node = head;
        while(node.next!=null){
            System.out.println(node.next.value);
            node = node.next;
        }
    }
}

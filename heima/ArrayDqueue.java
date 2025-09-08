package heima;

public class ArrayDqueue<E> implements Dqueue<E> {

    E[] array;
    int head;
    int tail;
    public ArrayDqueue(int capacity){
        array = (E[])new Object[capacity+1];
    }
    static int inc(int i,int length){
        if(i+1>length) return 0;
        return i+1;
    }
    static int dec(int i,int length){
        if(i-1<0) return length-1;
        return i-1;
    }
    @Override
    public boolean OfferFirst(E value) {
        if(isFull()) return false;
        head = dec(head, array.length);
        array[head] = value;
        return true;
    }

    @Override
    public boolean OfferLast(E value) {
        if(isFull()) return false;
        tail = inc(tail, array.length);
        array[tail] = value;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        if(tail>head) return tail-head == array.length-1;
        else if(tail<head) return head-tail == 1;
        else return false;
    }

    @Override
    public E peekFirst() {
        
        return array[head];
    }

    @Override
    public E peekLast() {

        return array[tail];
    }

    @Override
    public E pollFirst() {
        if(isEmpty()) return null;
        E value = array[head];
        head = inc(head, array.length);
        return value;
    }

    @Override
    public E pollLast() {
        if(isEmpty()) return null;
        E value = array[tail];
        tail = dec(head, array.length);
        return value;
    }
    
}

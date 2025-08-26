package heima;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E>{
    private ArrayList<E> array = new ArrayList<>();
    private int capacity;
    public ArrayStack(int capacity){
        this.capacity = capacity;
    }
    @Override
    public boolean isEmpty() {
        return array.size()==0;
    }

    @Override
    public boolean isFull() {
        return array.size()==capacity;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        array.addFirst(value);
        return true;
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
        return array.get(0);
    }

    @Override
    public E poll() {
        if(isEmpty()) return null;
        return array.removeFirst();
    }
    
    public void loop(){
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }
    }

}

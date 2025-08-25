package heima;

public class ArrayQueue<E> implements Queue<E>{

    private E[] arr;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        arr =  (E[]) new Object[capacity+1];
    }
    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean offer(E value) {
        if(!isFull()){
            arr[tail] = value;
            tail = (tail+1)%arr.length;
            return true;
        }else
        return false;
    }

    @Override
    public E peek() {
        if(!isEmpty()){
          return arr[head]; 
        }else
        return null;
    }

    @Override
    public E poll() {
        if(!isEmpty()){
            E value = arr[head]; 
            head = (head+1) % arr.length;
            return value;
        }else
          
          
        return null;
    }

    public boolean isFull(){
        return (tail+1)%arr.length == 0;
    }

    public void loop(){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

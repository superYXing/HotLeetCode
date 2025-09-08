package heima;
//优先级队列的无序数组实现 + 有序数组实现
public class PriorityQueue<E extends priority> implements Queue<E>{

    priority[] array;
    int size;

    public PriorityQueue(int capacity){
        array = new priority[capacity];
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        
        return size == 0;
    }

    @Override
    public boolean offer(E value) {
        /* 无序数组实现
        if(isFull()) return false;
        array[size++] = value;
        return true;
        */

        //有序数组
        if(isFull()) return false;
        int i=size-1;
        for(;i>=0;i--){
            if(array[i].priority>value.priority){
                array[i+1] = array[i];
            }else{
                  break;
            }
        }
        array[i+1] = value;
        size++;

        return true;
    }

    public int selectMax(){
        int max = 0;
        for(int i = 0; i < size; i++){
            if(array[i].priority>array[max].priority){
                max = i;
            }
        }
        return max;
    }
    
    @Override
    @SuppressWarnings("all")
    public E peek() {
        /* 无序数组实现
        if(isEmpty()) return null;
        int max = selectMax();
        return (E)array[max];
        */
        //有序数组
        if(isEmpty()) return null;
        return (E)array[size-1];
    }

    @Override
    @SuppressWarnings("all")
    public E poll() {
        /* 无序数组实现
        if(isEmpty()) return null;
        int max = selectMax();
        E value = (E)array[max];
        //remove
        if(max == size-1){
            size--;
        }else{
            System.arraycopy(array, max+1, array, max, size-1-max);
            size--;
            
        }
        array[size] = null;
        
        return value;
    }
        */

        //有序数组
        if(isEmpty()) return null;
        return (E)array[--size];
    }

    public boolean isFull(){
        return size == array.length;
    }

    

}

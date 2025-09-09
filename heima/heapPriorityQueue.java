package heima;

public class heapPriorityQueue<E extends priority> extends PriorityQueue<E> {

    // 调用父类构造方法
    public heapPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    @Override
    public boolean offer(E value) {
        if(isFull()) return false;
        int child = size;
        size++;
        int parent = (child-1)/2;
        while(child > 0 && value.priority > array[parent].priority){
            array[child] = array[parent];
            child = parent;
            parent =  (child-1)/2;
        }
        array[child] = value;
        return true;
    }

    @Override
    @SuppressWarnings("all")
    public E peek() {
        if(isEmpty()) return null;
        return (E)array[0];
    }

    @Override
    @SuppressWarnings("all")
    public E poll() {
        if(isEmpty()) return null;
        size--;
        E value = (E)array[0];
         // 将最后一个元素移到根位置
        array[0] = array[size];
        array[size] = null;
        int n = 0;
        int leftchild = 2*n+1, rightchild = 2*n+2;
        //向下调整
        while(leftchild<size){
              //找到要交换的孩子结点
             int exchange = leftchild;
            if(rightchild<size&&array[rightchild].priority>array[leftchild].priority){
                exchange = rightchild;
            }
            //判断是否结束
            if(array[n].priority>=array[exchange].priority){
                break;
            }
          
           //交换
            E mid = (E)array[exchange];
            array[exchange] = array[n];
            array[n] = mid;
            //赋值
            n = exchange;
            leftchild = 2*n+1;
            rightchild = 2*n+2;
            
        }
        return value;
    }
    

}

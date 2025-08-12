package java_exercise.synthesizer;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{

    private T[] items;
    private int first;
    private int last;
        // 构造函数，初始化队列容量
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity]; // 泛型数组创建方式
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
    }
    @Override
    public int capacity() {
        return capacity;

    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public void enqueue(T x) {
        if (isFull()) {
            System.out.println("quene is full");
            return;
        }
        items[last] = x;
        last = (last + 1) % capacity;
        fillCount ++ ;
        return;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            System.out.println("quene is null");
        }
        T item = items[first];
        items[first] = null; // 避免内存泄漏
        first = (first +1) % capacity;
        fillCount -- ;
        return item;
    }

    @Override
    public T peek() {
            if (isEmpty()) {
            throw new RuntimeException("Ring buffer is empty");
        }
        T item = items[first];
        return item;
    }

}

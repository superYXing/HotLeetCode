/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */
import java.util.Comparator;
import java.util.PriorityQueue;
// @lc code=start
class MedianFinder {


/**
 * 堆操作工具类，支持小根堆和大根堆的常见操作
 */
public class HeapUtils<T> {
    private final PriorityQueue<T> heap;
    
    /**
     * 构造小根堆（默认自然排序）
     */
    public HeapUtils() {
        this.heap = new PriorityQueue<>();
    }

    /**
     * 构造自定义排序的堆
     * @param comparator 比较器，传入Comparator.reverseOrder()可创建大根堆
     */
    public HeapUtils(Comparator<? super T> comparator) {
        this.heap = new PriorityQueue<>(comparator);
    }

    /**
     * 向堆中插入元素
     * @param element 要插入的元素
     * @return 插入成功返回true
     */
    public boolean push(T element) {
        if (element == null) {
            throw new NullPointerException("元素不能为null");
        }
        return heap.offer(element);
    }

    /**
     * 获取堆顶元素（不删除）
     * @return 堆顶元素，若堆为空返回null
     */
    public T peek() {
        return heap.peek();
    }

    /**
     * 移除并返回堆顶元素
     * @return 堆顶元素，若堆为空返回null
     */
    public T pop() {
        return heap.poll();
    }

    /**
     * 判断堆是否为空
     * @return 空返回true，否则返回false
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * 获取堆中元素数量
     * @return 元素数量
     */
    public int size() {
        return heap.size();
    }

    /**
     * 清空堆中所有元素
     */
    public void clear() {
        heap.clear();
    }
}
   
    HeapUtils<Integer> minHeap;
    HeapUtils<Integer> maxHeap;

    public MedianFinder() {
    minHeap = new HeapUtils<>();
    maxHeap = new HeapUtils<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        int value;
        if(minHeap.size()==maxHeap.size()){
            maxHeap.push(num);
            value = maxHeap.pop();
            minHeap.push(value);
        }else{
            minHeap.push(num);
            value = minHeap.pop();
            maxHeap.push(value);
        }
    }
    
    public double findMedian() {
        if(minHeap.size()!=maxHeap.size()) return maxHeap.peek();
        else return ((double)maxHeap.peek()+minHeap.peek())/2;
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end


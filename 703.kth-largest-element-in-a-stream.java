/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {

public static class MinHeap {
    int[] array;
    int size;
    public MinHeap(int capacity){
        array = new int[capacity];
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return array.length == size;
    }

    public void heapify(){
        //Floyd建堆算法，先找到最后一个非叶子节点
        for(int i = size / 2 - 1 ; i >= 0 ; i--){
            //down下沉
            down(i);  
        }
    }
    public void down(int i){
        while(true)
{           int left = i*2+1;
            int right = i*2+2;
            int max = i;
            if(left<size&&array[left]<array[max]){
                max = left;
            }
            if(right<size&&array[max]>array[right]){
                max = right;
            }
            if(max==i) break;
            //交换位置
            swap(max,i);
            i=max;
        }
    }
    public void swap(int max,int i){
            int temp = array[max];
            array[max] = array[i];
            array[i] = temp;
    }




        public int peek(){
            return array[0];
        }

        public void offer(int num){
            if(isFull()) return;
            //赋值
            int child = size;
            size++;

            //上浮
            up(num,child);
        }

        public void up(int offered,int child){
           array[child] = offered;
            while(child>0){
                 int parent = (child-1) / 2; 
                if(array[parent]>offered){
                    swap(parent, child);
                    child=parent;
                }else{
                    break;
                }
            }
          
        }
        //替换堆顶元素
        public void replace(int num){
            array[0] = num;
            down(0);
        }

}
    

    MinHeap minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap= new MinHeap(k);
        for(int num:nums) add(num);
    }
    
    public int add(int val) {
        if(!minHeap.isFull()){
            minHeap.offer(val);
        }else{
            if(val>minHeap.peek()) minHeap.replace(val);
        }
        return minHeap.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end


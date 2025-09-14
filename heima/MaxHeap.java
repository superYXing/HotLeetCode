package heima;

public class MaxHeap {
    int[] array;
    int size;
    public MaxHeap(int capacity){
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
            int left = i*2+1;
            int right = i*2+2;
            int max = i;
            if(left<size&&array[left]>array[i]){
                max = left;
            }
            if(right<size&&array[max]<array[right]){
                max = right;
            }
            //交换位置
            int temp = array[max];
            array[max] = array[i];
            array[i] = temp;
        }
    }
         public int poll(){
            int res = array[0];
            array[0] = array[--size];
            heapify();
            return res;
        }
        public int poll(int index){
            int res = array[index];
            array[index] = array[--size];
            heapify();
            return res;
        }

        public int peek(){
            return array[0];
        }

        public void offer(int num){
            if(isFull()) return;
            //上浮
            int child = size;
            array[child] = num;
             size++;
            int parent = (child-1) / 2; 
            while(child>0&&array[parent]<array[child]){
                //交换
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
                child = parent;
                parent = (parent-1) / 2;
            }
           
            
        }
        //替换堆顶元素
        public void replace(int num){
            array[0] = num;
            heapify();
        }
        //优化：提取出down，up，swap三个函数并应用
}

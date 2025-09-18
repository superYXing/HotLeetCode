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
            down(i);  
        }
    }
    public void down(int i){
        while(true)
{           int left = i*2+1;
            int right = i*2+2;
            int max = i;
            if(left<size&&array[left]>array[max]){
                max = left;
            }
            if(right<size&&array[max]<array[right]){
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

         public int poll(){
                    if (isEmpty()) {
            throw new RuntimeException("堆为空，无法删除元素");
        }
            int res = array[0];
            array[0] = array[--size];
            down(0);
            return res;
        }
        public int poll(int index){
                    if (isEmpty()) {
            throw new RuntimeException("堆为空，无法删除元素");
        }
            int res = array[index];
            up(Integer.MAX_VALUE,index);
            size--;
            return res;
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
                if(array[parent]<offered){
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
        public static void main(String[] args) {
            MaxHeap maxheap = new MaxHeap(5);
            //插入5个元素
            for(int i =0;i<5;i++) maxheap.offer(i);
            //堆化
            maxheap.heapify();
            //每次都把最底层元素放到根节点再下潜
            while(maxheap.size>1){
            maxheap.swap(--maxheap.size, 0);
            maxheap.down(0);
            }
            //输出结果
            for(int i = 0 ; i<maxheap.array.length;i++)
            System.out.println(maxheap.array[i]);
        }
}
    

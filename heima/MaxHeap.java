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
           
            while(child>0){
                 int parent = (child-1) / 2; 
                if(array[parent]<array[child]){
                    swap(parent, child);
                    child=parent;
                }else{
                    break;
                }
            }
            array[child] = offered;
        }
        //替换堆顶元素
        public void replace(int num){
            array[0] = num;
            down(0);
        }
        //优化：提取出down，up，swap三个函数并应用
}

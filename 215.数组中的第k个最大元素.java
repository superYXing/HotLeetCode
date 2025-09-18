//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2819 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public class MinHeap {
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
                if(array[parent]<=offered) break;
                array[child] = array[parent];        // 父节点下沉
                child = parent;
            }
            array[child] = offered;
        }
        //替换堆顶元素
        public void replace(int num){
            array[0] = num;
            down(0);
        }

    }




    public int findKthLargest(int[] nums, int k) {
        MinHeap minheap =  new MinHeap(k);
        minheap.heapify();
        for(int i = 0 ; i < k;i++){
            minheap.offer(nums[i]);
        }
        for(int i = k; i < nums.length;i++){
            if(minheap.peek()<nums[i]){
//                minheap.array[0]   = nums[i];
//                minheap.down(0);
                minheap.replace(nums[i]);
            }
        }
        return minheap.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start


 
class minHeap{

    ListNode[] array;
    int size;

    public minHeap(int capacity){
        array = new ListNode[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==array.length;
    }

    public boolean offer(ListNode node) {
        if(isFull()) return false;
        int child = size;
        size++;
        int parent = (child-1)/2;
        while(child > 0 && node.val < array[parent].val){
            array[child] = array[parent];
            child = parent;
            parent =  (child-1)/2;
        }
        array[child] = node;
        return true;
    }


    public ListNode peek() {
        if(isEmpty()) return null;
        return array[0];
    }


    public ListNode poll() {
        if(isEmpty()) return null;
        size--;
        ListNode result = array[0];
         // 将最后一个元素移到根位置
        array[0] = array[size];
        array[size] = null;
 // 向下调整逻辑
        int parent = 0;
        while(true) {
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            int minIndex = parent;
            
            if(leftChild < size && array[leftChild].val < array[minIndex].val) {
                minIndex = leftChild;
            }
            if(rightChild < size && array[rightChild].val < array[minIndex].val) {
                minIndex = rightChild;
            }
            
            if(minIndex == parent) break;
            
            // 交换节点
            ListNode temp = array[parent];
            array[parent] = array[minIndex];
            array[minIndex] = temp;
            
            parent = minIndex;
        }
        return result;
    }
    
    

}
class Solution {
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            
    //     if(list1==null) return list2;
    //     else if(list2==null) return list1;
    //     else if(list2.val>list1.val){
    //         list1.next=mergeTwoLists(list1.next, list2);
    //         return list1;
    //     } 
    //     else{
    //         list2.next=mergeTwoLists(list1,list2.next);
    //         return list2;
    //     }

    // }
    public ListNode mergeKLists(ListNode[] lists) {
        minHeap heap = new minHeap(lists.length);
        for(ListNode node : lists){
            if(node!=null)
            heap.offer(node);
        }
        ListNode dummy = new ListNode(-1,null);
        ListNode n = dummy;

        while(!heap.isEmpty()){
            ListNode min = heap.poll();
            n.next = min;
            n=n.next;
            if(min.next!=null)
            heap.offer(min.next);
        }
        return dummy.next;

        // if(lists.length==0) return null;
        // int k = lists.length;
        // while(k>1){
        //     int idx=0;
        //     for(int i=0;i<k;i+=2){
        //         if(i==k-1){
        //             lists[idx++] = lists[i];
        //         }else{
        //             lists[idx++] = mergeTwoLists(lists[i], lists[i+1]);
        //         }
        //     }
        //     k=idx;
        // }
        // return lists[0];
    }

    
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            
        if(list1==null) return list2;
        else if(list2==null) return list1;
        else if(list2.val>list1.val){
            list1.next=mergeTwoLists(list1.next, list2);
            return list1;
        } 
        else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        int k = lists.length;
        while(k>1){
            int idx=0;
            for(int i=0;i<k;i+=2){
                if(i==k-1){
                    lists[idx++] = lists[i];
                }else{
                    lists[idx++] = mergeTwoLists(lists[i], lists[i+1]);
                }
            }
            k=idx;
        }
        return lists[0];
    }
}
// @lc code=end


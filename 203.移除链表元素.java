/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        ListNode prev = null;
        while(p!=null){
            if(p.val==val){
            if(prev == null) {
                    // 删除头节点，更新head
                    head = head.next;
                    p = head;
                }else{
                    prev.next=p.next;
                    p=p.next;
                }
            }else{
                prev=p;
                p=p.next;
            }
        }
        return head;
    }
}
// @lc code=end


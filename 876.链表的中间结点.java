/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p=p.next;
        }
        int pos = len/2;
        ListNode tar = head;
        for(int i=0;i<pos;i++){
            tar=tar.next;
        }
        return tar;
    }
}
// @lc code=end


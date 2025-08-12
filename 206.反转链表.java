/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
      ListNode n1 = head;
      ListNode o2 = head.next;
      while(o2!=null){
        //先把o2从链表中断开
        head.next=o2.next;
        //o2插入到链表头
        o2.next=n1;
        //n1指向o2
        n1=o2;
        //o2指向head下一个结点
        o2=head.next;
      }
      return n1;
      
    }
}

// @lc code=end


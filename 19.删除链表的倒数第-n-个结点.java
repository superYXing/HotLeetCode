/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode s = new ListNode(-1,head);
       ListNode prev = s;
       ListNode curr = s;
       int len =0;
       //计算链表长度（包括头节点）
       while(curr!=null){
        len++;
         // System.out.println("value:: "+s.val);
        curr=curr.next;
       
       }
      
      //   System.out.println("length(): "+len);
       //计算删除的正序位置(从0计算)
       int pos = len-n;
    //    ListNode curr = s;
       //开始删除
       for(int i=0;i<pos-1&&prev!=null;i++){
        prev=prev.next;
       }
      //   System.out.println("prev.value(): "+prev.val);
       prev.next=prev.next.next;
       return s.next;
    }
}
// @lc code=end


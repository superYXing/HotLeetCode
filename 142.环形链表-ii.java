/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //判断是否有环
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            p2=p2.next;
            if(p1==p2) break;            
        }
            // 如果没有环，返回null
        if (p2 == null || p2.next == null) {
            return null;
        }
        p1=head;
        while (p1 != p2) {  
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    }

// @lc code=end


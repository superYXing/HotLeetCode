/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
    //     if(head==null) return null;
    //     ListNode s = new ListNode (-1,head);
    //     //双指针
    //     ListNode prev = s;
    //     ListNode curr = head;
    //    while(curr!=null){
    //     if(curr.next!=null&&curr.val==curr.next.val){
    //         //移除
    //         System.out.println(curr.val);
    //         int num = curr.val;
    //         while(curr!=null&&curr.val==num){
    //             curr=curr.next;
    //         }
    //         prev.next=curr;
    //         // prev=prev.next;
    //         // curr=next;
    //         // next=next.next;
    //     } 
    //     else{
    //         prev=curr;
    //         curr=curr.next;
    //     }
    //    }
    //    return s.next;
    // }

    //三指针
    if(head==null) return null;
    ListNode s = new ListNode(-1,head);
    ListNode p1 = s;
    ListNode p2 = head;
    ListNode p3 = head.next;
    while(p2!=null&&p3!=null){
        if(p2.val==p3.val){
            while(p3!=null&&p2.val==p3.val){
                p3=p3.next;
            }
            p1.next = p3;
            p2=p1.next;
                if(p3 != null) {
                    p3 = p3.next;
                }
        }else{
            p1=p1.next;
            p2 = p3; 
                if(p3 != null) {
                    p3 = p3.next;
                }
        }      
    }
    return s.next;
}
}
// @lc code=end


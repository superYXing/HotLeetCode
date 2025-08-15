/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
       //*********************************迭代法******************************* */
        // ListNode s = new ListNode(-1);
        //  ListNode curr = s;
        // while(list1!=null&&list2!=null){
        //     if(list2.val<=list1.val){
        //         curr.next=list2;
        //         list2=list2.next;
        //     }else{
        //         curr.next=list1;
        //         list1=list1.next;
        //     }
        //     System.out.println(curr.val);
        //     curr=curr.next;
        // }
        // if(list1==null&&list2!=null){
        //     while(list2!=null){
        //         curr.next=list2;
        //         list2=list2.next;
        //         curr=curr.next;
        //     }
        // }
        //     if(list2==null&&list1!=null){
        //     while(list1!=null){
        //         System.out.println("there");
        //         curr.next=list1;
        //         list1=list1.next;
        //         curr=curr.next;
        //     }
        // }
        // return s.next;

        // *******************************************递归法*******************************************
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
}
// @lc code=end


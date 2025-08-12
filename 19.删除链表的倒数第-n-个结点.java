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
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int tar = arr.size() - n;
        arr.remove(tar);
                if(arr.isEmpty()) return null;
        System.out.println(arr.toString());
        //新建链表返回
        ListNode newHead = new ListNode(arr.get(0));
        ListNode curr = newHead;
        for(i=1;i<arr.size();i++){
          curr.next=new ListNode(arr.get(i));
          curr = curr.next;
        }
        return newHead;
    }
}
// @lc code=end


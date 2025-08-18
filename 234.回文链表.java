/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;

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
    public boolean isPalindrome(ListNode head) {
        // ListNode p = head;
        // ArrayList<Integer> arr = new ArrayList<>();
        // while(p!=null){
        //     arr.add(p.val);
        //     p=p.next;
        // }
               
        // ArrayList<Integer> re = new ArrayList<>(arr);
        // Collections.reverse(re);
        //  System.out.println("arr: "+ arr.toString());
        // System.out.println("re:" +re.toString());
        // if(arr.equals(re)) return true;
        // else return false;
        
        //更快的方法
        int len = 0;
        int mid = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p=p.next;
        }
        System.out.println("len:"+ len);
        mid= (len+1)/2;
        ListNode node = head;
        for(int i=0;i<mid;i++,node=node.next);

         
        ListNode p2 = null;
        while(node!=null){
            System.out.println("node:"+ node.val);
            p2=new ListNode(node.val,p2);
           
            node = node.next;
        }
 
        while(p2!=null&&head!=null){
            System.out.println("p2: " + p2.val );
            if(p2.val!=head.val) return false;
           
            p2=p2.next;
            head = head.next;
        }
        return true;
        
        

    }
}
// @lc code=end


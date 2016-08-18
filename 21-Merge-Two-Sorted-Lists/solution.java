/**
 * 21. Merge Two Sorted Lists
 * 1 solution
 * 
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// s1: brute force, use a dummy node
// O(n), O(1)

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       // corner case
       if (l1 == null) {
           return l2;
       }
       if (l2 == null) {
           return l1;
       }
       
       ListNode dummy = new ListNode(0);
       ListNode node = dummy;
       
       while (l1 != null && l2 != null) {
           if (l1.val <= l2.val) {
               node.next = l1;
               l1 = l1.next;
           } else {
               node.next = l2;
               l2 = l2.next;
           }
           node = node.next;
       }
       
       if (l1 != null) {
           node.next = l1;
       }
       if (l2 != null) {
           node.next = l2;
       }
       return dummy.next;
    }
}
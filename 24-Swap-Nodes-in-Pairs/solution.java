/**
 * 24. Swap Nodes in Pairs
 * 
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
 
// s1: LeetCode reverse linked list
// O(n), O(1) 

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            prev.next = temp;
            temp.next = head;
            
            head = head.next;
            prev = prev.next.next;
        }
        
        return dummy.next;
    }
}
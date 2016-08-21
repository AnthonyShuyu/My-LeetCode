/**
 * 
 * 203. Remove Linked List Elements
 * 
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
 
// s1: brute force, dummy node
// O(n), O(1)

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // corner case
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        
        while (head != null) {
            if (node.next.val == val && node.next != null) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
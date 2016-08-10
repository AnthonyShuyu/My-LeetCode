/**
 * 82. Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int n = head.next.val;
                while (head.next != null && head.next.val == n) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
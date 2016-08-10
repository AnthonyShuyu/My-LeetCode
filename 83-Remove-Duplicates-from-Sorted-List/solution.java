/**
 * 83. Remove Duplicates from Sorted List
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
 
 
// s1: brute force
// O(n), O(1)

/*
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // corner case
        if (head == null) {
            return head;
        }
        ListNode node = head;
        
        while (head != null) {
            int val = head.val;
            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return node;
    }
}
*/

// s2: use dummy node
// O(n), O(1)

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (head != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
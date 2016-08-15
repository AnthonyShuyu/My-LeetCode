/**
 * 206. Reverse Linked List
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
 
// s1: brure force
//use two pointers, one is the prev, one is the head, and move to the next node together, remember the 4 steps.
// 4 steps， the variale appears at the right of the "=" will appear at the left of the next "="
// O(n), O(1)


/*
public class Solution {
    public ListNode reverseList(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
} 
*/


public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
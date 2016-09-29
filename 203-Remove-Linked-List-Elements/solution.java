/**
 * 
 * 203. Remove Linked List Elements
 * 1 solution
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

/*
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
*/


// s1 modified: dummy node
// O(n), O(1)

/*
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // corner case
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;   
    }
}
*/


// s1 again, OA practice
// O(n), O(1)

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // corner case
        ListNode node = null;
        if (head == null) {
            return node;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }    
}
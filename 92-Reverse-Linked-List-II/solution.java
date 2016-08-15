/**
 * 92. Reverse Linked List II
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
 
// s1: brute force, use the solution in reverse Linked List I
// O(n), O(1)
// failed

/*
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // corner case
        if (head == null || head.next == null || m <= n) {
            return head;
        }
        ListNode tail = head;
        ListNode prev = head;
        for (int i = 0; i < n; i++) {
            if (prev != null) {
                prev = prev.next;
            } else {
                return null;
            }
        }
        for (int i = 0; i < m - 1; i++) {
            if (tail != null) {
                tail = tail.next;
            } else {
                return null;
            }
        }
        
        for (int i = 0; i < n - m + 1; i++) {
            ListNode temp = tail.next;
            tail.next = prev;
            prev = tail;
            tail = temp;
        }
        
        head.next = prev;
        return head;
    }
} 
*/


// s1: dummy node + reverse linked list I + two pointers
// O(n), O(1)

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // corner case
        if (head == null || head.next == null || m >= n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 0; i < m - 1; i++) {
            if (head != null) {
                head = head.next;
            } else {
                return null;
            }
        }
        
        ListNode mNode = head.next;
        ListNode prev = mNode;
        ListNode post = prev.next;
        
        for (int i = 0; i < n - m; i++) {
            ListNode temp = post.next;          // store the post.next to move the two pointers
            post.next = prev;
            prev = post;
            post = temp;
        }
        
        mNode.next = post;
        head.next = prev;
        return dummy.next;
    }
}

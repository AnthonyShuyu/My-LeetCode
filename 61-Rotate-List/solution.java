/**
 * 
 * 61. Rotate List
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
 
// s1: 3 times reverse
// O(n), O(1)
// failed, it is complicated in the linkedlist to use 3 times reverse
 
/*
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        int count = getLength(head);
        k = k % count;
        if (k == 0) {
            return head;
        }
        
        int n = count - k;
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        ListNode right = node.next;
        node.next = null;
        ListNode left = reverseList(head);
        right = reverseList(right);
        ListNode result = left;
        while (left.next != null) {
            left = left.next;
        }
        left.next = right;
        return reverseList(result);
        
    }
    
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
    
    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
*/


// s2: use 2 pointers, get the length of list and move one pointer to the end of the list at the same time
// O(1), O(1)

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // corner case
        if (head == null && head.next == null) {
            return head;
        }
        
        // get length and move one pointer to the end of the list
        int count = 1;
        ListNode node = head;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        k = k % count;
        
        int step = n - k - 1;
        
        ListNode temp = head;
        for (int i = 0; i < step; i++) {
            temp = temp.next;
        }
        
        ListNode right = temp.next;
        temp.next = null;
        node.next = head;
        return node;
        
    }
}
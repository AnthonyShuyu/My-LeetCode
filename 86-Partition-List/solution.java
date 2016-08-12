/**
 * 86. Partition List
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
 
 
// s1: brute force, create another listNode and merge them, use dummy node
// O(n), O(n)
 
 
/* 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        
        ListNode dummy1 = node1;
        ListNode dummy2 = node2;
        
        while (head != null) {
            if (head.val < x) {
                ListNode node = new ListNode(head.val);
                node1.next = node;
                node1 = node1.next;
            } else {
                ListNode node = new ListNode(head.val);
                node2.next = node;
                node2 = node2.next;
            }
            head = head.next;
        }
        node1.next = dummy2.next;
        return dummy1.next;
    }
}

*/



// *s2: two dummy nodes, two heads, don't forget: head2.next = null
// O(n), O(1)

public class Solution {
    public ListNode partition(ListNode head, int x) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        
        while (head != null) {
            if (head.val < x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        head1.next = dummy2.next;
        head2.next = null;
        return dummy1.next;
    }
}
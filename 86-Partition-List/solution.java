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
// O(n), O(1)
 
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
            if (head.val >= x) {
                node1.next = head;
                node1 = node1.next;
            } else {
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node1.next = dummy2.next;
        return dummy1.next;
    }
}
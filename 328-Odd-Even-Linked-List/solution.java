/**
 * 
 * 328. Odd Even Linked List
 * 
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
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
 
 
// s1: brute force, partition to 2 lists and connect them at last
// O(n), O(1)

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode node1 = dummy1;
        ListNode node2 = dummy2;
        
        int n = 0;
        while (head != null) {
            if (n % 2 == 0) {
                node1.next = head;
                node1 = node1.next;
            } else {
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
            n++;
        }
        
        node1.next = dummy2.next;
        node2.next = null;
        return dummy1.next;
    }
}
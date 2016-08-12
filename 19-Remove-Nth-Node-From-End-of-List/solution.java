/**
 * 19. Remove Nth Node From End of List
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
 
// s1: brute force, dummy node, move (length of the list - n) steps
// O(n), O(1)

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // corner case
        if (head == null || n <= 0) {
            return null;
        }
        
        ListNode node = head;
        
        //count the length of the list
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        
        int step = length - n;
        if (step < 0) {
            return null;
        }
        
        // create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 0; i < step; i++) {
            if (head != null) {
                head = head.next;
            } else {
                return null;
            }
        }
        if (head.next != null) {
            head.next = head.next.next;
        }
        return dummy.next;
        
    }
}
/**
 * 143. Reorder List
 * 
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
 
// s1: find the middle node, reverse the next half of the list, and merge two lists
// O(n), O(1)

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mNode = findMiddle(head);
        ListNode nNode = mNode.next;
        
        ListNode right = reverseList(nNode);
        mNode.next = null;
        
        ListNode left = head;
        mergeTwoLists(left, right);
        
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
    
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (node1 != null && node2 != null) {
            node.next = node1;
            node = node.next;
            node.next = node2;
            node = node.next;
            
            node1 = node1.next;
            node2 = node2.next;
        }
        
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return dummy.next;
    }
    
    public ListNode findMiddle(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
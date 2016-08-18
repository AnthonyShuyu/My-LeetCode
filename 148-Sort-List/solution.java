/**
 * 148. Sort List
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
 
 
// s1: O(nlogn) time and O(1) space, think of merge sort, divide and conquer(merge two linked lists)
// O(nlogn), O(1)

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int length = countLength(head);
        ListNode node = head;
        for (int i = 0; i < length / 2; i++) {
            node = node.next;
        }
        ListNode left = head;
        
        // ListNode right = node.next;
        // node.next = null;
        // ListNode left = head;
        
        // ListNode rightList = sortList(right);
        // ListNode leftList = sortList(left);

        ListNode right = node.next;
        ListNode rightList = sortList(right);
        node.next = null;
        ListNode leftList = sortList(left);

        return mergeLists(leftList, rightList);
    }
    
    public int countLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    
    
    // LeetCode 
    public ListNode mergeLists(ListNode head1, ListNode head2) {
        // if (head1 == null) {
        //     return head2;
        // }
        // if (head2 == null) {
        //     return head1;
        // }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        
        if (head1 != null) {
            node.next = head1;
        }
        
        if (head2 != null) {
            node.next = head2;
        }
        return dummy.next;
    }
}
/**
 * 83. Remove Duplicates from Sorted List
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
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // corner case
        if (head == null) {
            return head;
        }
        ListNode node = head;
        
        while (head.next != null) {
            int val = head.val;
            while (head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return node;
    }
}
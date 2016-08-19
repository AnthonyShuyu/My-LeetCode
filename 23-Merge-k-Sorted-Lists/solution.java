/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// s1: brute force, merge two lists at one time
// O(n * m), O(1)

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = mergeTwoLists(list, lists[i]);
        }
        return list;
    }
    
    // LC merge two sorted lists
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        // corner case
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return dummy.next;
    }
}
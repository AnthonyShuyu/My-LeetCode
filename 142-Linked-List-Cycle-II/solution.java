/**
 * 142. Linked List Cycle II
 * 
 * 
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
// s1: find repeatation or common, use HashSet
// O(n), O(n)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        Set<ListNode> hashSet = new HashSet<ListNode>();
        
        while (head != null) {
            if (hashSet.contains(head)) {
                return head;
            } else {
                hashSet.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
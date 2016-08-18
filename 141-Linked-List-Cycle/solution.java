/**
 * 141. Linked List Cycle
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
 
// s1: find repeatation, use HashSet data structure
// O(n), O(n)
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> hashSet = new HashSet<ListNode>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            } else {
                hashSet.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
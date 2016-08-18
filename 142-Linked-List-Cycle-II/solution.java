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

/*
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
*/

// s2: achieve O(1) space, use slow and fast pointers
// O(n), O(1)
// failed, not consider the situation where the cycle node is the head

/*
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (slow != fast) {
            return null;
        } 
        
        slow = head;
        while (slow != null && fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (slow == fast) {
            return slow;
        }
        return null;
    }
}
*/

// s2 modified: achieve O(1) space, use slow and fast pointers, plus dummy node
// O(n), O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (slow != fast) {
            return null;
        } 
        
        slow = dummy;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        if (slow == fast) {
            return slow;
        }
        return null;
    } 
}
/**
 * 160. Intersection of Two Linked Lists
 * 
 * 
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 
// Aak questions: they are singly linked list?
// Assume they are

// s1: how to check if two linked lists are the same? the intersection is defined based on reference
// To use brute force

// O(n^2), O(1)
// Time limit exceeded

/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node = headB;
        
        while (headA != null) {
            while (headB != null) {
                if (headA == headB) {
                    return headA;
                } else {
                    headB = headB.next;
                }
            }
            headA = headA.next;
            headB = node;
        }
        return null;
    }
}
*/

// s2: look for the solution, how to check two things have something in common? can use HashMap/HashSet data structure
// O(n), O(n)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> hashSet = new HashSet<ListNode>();
        
        while (headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hashSet.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }
}
/**
 * 160. Intersection of Two Linked Lists
 * 3 solutions
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

/*
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
*/

// s3: how to achieve O(n) and O(1)? can not use other data structure, look for the solution here is the tricky, if they are not the same length, the longer one can drop of the first (len1 - len2) nodes because they are useless, if they are the intersection, they may be the part of another linkedList
// O(n), O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = 0;
        int lengthB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            lengthB++;
            nodeB = nodeB.next;
        }
        if (lengthA < lengthB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int diff = Math.abs(lengthA - lengthB);
        for (int i = 0; i < diff; i++) {
            headA = headA.next;
        }
        
        // compare each other move the same step forward
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}

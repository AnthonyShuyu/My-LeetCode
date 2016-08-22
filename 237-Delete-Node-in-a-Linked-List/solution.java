/**
 * 
 * 237. Delete Node in a Linked List
 * 1 solution
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
 
// s1: brute force, find the node and delete it 
// O(n), O(1)
// failed!! worng conception
/*
public class Solution {
    public void deleteNode(ListNode node) {
       // corner case
       if (node == null) {
           return;
       }
       node = node.next;
    }
}
*/

// s2: copy the node's next node over to the node
// O(n), O(1)

public class Solution {
    public void deleteNode(ListNode node) {
        // corner case
        if (node == null ) {
            return;
        }
        if (node.next != null) {
            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = node.next.next;
        }
    }
}
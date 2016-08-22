/**
 * 25. Reverse Nodes in k-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
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
 
// s1: brute force
// O(n), O(1)

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       // corner case
       if (head == null || head.next == null || k <= 0) {
           return head;
       }
       
       int length = countLength(head);
       
       if (k > length) {
           return head;
       } else {
           return reverseList(head, k);
       }
    }
    
    public int countLength(ListNode head) {
        // corner case
        if (head == null) {
            return 0;
        }
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode reverseList(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode postNode = dummy.next;
        
        int count = 0;
        
        ListNode node = head;
        ListNode preNode = dummy;
        
        while (postNode != null) {
            count++;
            postNode = postNode.next;
            if (count % k == 0) {
                ListNode prev = postNode;
                while (node != postNode) {
                    ListNode temp = node.next;
                    node.next = prev;
                    prev = node;
                    node = temp;
                }
                ListNode temp2 = preNode.next;
                preNode.next = prev;
                preNode = temp2;
            }
        }
        
        return dummy.next;
    }
}
/**
 * 
 * 2. Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
		//corner case
		if (node1 == null || node2 == null) {
			return null;
		}
		
		int carry = 0;
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while (node1 != null && node2 != null) {
			int num1 = node1.val;
			int num2 = node2.val;
			ListNode newNode = new ListNode((num1 + num2 + carry) % 10);
			carry = (num1 + num2 + carry) / 10;
			head.next = newNode;
			head = head.next;
			node1 = node1.next;
			node2 = node2.next;
		}
		
		while(node1 != null) {
			int num1 = node1.val;
			ListNode newNode = new ListNode((num1 + carry) % 10);
			head.next = newNode;
			head = head.next;
			carry = (num1 + carry) / 10;
		}
		
		while (node2 != null) {
			int num2 = node2.val;
			ListNode newNode = new ListNode((num2 + carry) % 10);
			head.next = newNode;
			head = head.next;
			carry = (num2 + carry) / 10;
		}
		
		if (carry == 1) {
			ListNode newNode = new ListNode(1);
			head.next = newNode;
		}
		return dummy.next;

        
    }
}
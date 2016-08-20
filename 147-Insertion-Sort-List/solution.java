/**
 * 147. Insertion Sort List
 * 
 * 
 */

// this is not insertion sort, this is like bubble sort if I exchange two adjacent elements each time
/*	
	public void insertSort2(int[] array) {
		for (int i = 1; i < array.length; i++) { 
			int temp = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (temp < array[j]) {
					array[j + 1] = array[j];
					array[j] = temp; 
				}
			}
			
		}
	}
*/

// this is insert sort
/*
	public void insertSort2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int index = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (temp < array[j]) {
					array[j + 1] = array[j]; 
				} else {
					index = j + 1;
					break;
				}
			}
			array[index] = temp; 
		}
	}
*/	


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// s1: insert sort, dummy node
// O(n ^ 2), O(n)
 
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        
        head = head.next;
        
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && head.val >= node.next.val && node.next != head) {
                node = node.next;
            } 
            ListNode nextHead = head.next;
            
            if (node.next != head) {
                ListNode temp = node.next;
                temp.next = null;
                node.next = head;
                head.next = temp;
            }
            head = nextHead;
        }
        return dummy.next;
    }
}
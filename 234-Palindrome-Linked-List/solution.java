/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// s1: use an arrayList to check if it is a palindrome or not
// O(n), O(n)

/*
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return true;
        }
        
        List<Integer> arrayList = new ArrayList<Integer>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        System.out.println(arrayList);
        return checkPalindrome(arrayList);    
    }
    
    public boolean checkPalindrome(List<Integer> arrayList) {
        for (int i = 0, j = arrayList.size() - 1; i <= j; i++, j--) {
            if (!arrayList.get(i).equals(arrayList.get(j))) {
                return false;
            }
        }
        return true;
    }
}
*/


// s2: follow up, reverse and compare, fast and slow pointers
// O(n), O(1)

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode node2 = slow.next;
        slow.next = null;
        ListNode node1 = head;
        
        // reverse node2
        ListNode prev = null;
        while (node2 != null) {
            ListNode temp = node2.next;
            node2.next = prev;
            prev = node2;
            node2 = temp;
        }
        
        // compare the two lists
        while (prev != null) {
            if (node1.val != prev.val) {
                return false;
            }
            prev = prev.next;
            node1 = node1.next;
        }
        return true;
    }
}
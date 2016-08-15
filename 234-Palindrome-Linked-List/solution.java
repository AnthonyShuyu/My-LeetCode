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
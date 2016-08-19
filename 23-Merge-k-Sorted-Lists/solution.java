/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// s1: brute force, merge two lists at one time
// O(n * k), O(1), k is the length of lists, n is the average length of each listNode
// time limit exceeded

/*
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode list = lists[0];
        for (int i = 1; i < lists.length; i++) {
            list = mergeTwoLists(list, lists[i]);
        }
        return list;
    }
    
    // LC merge two sorted lists
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        // corner case
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return dummy.next;
    }
}
*/

// s2: divide and conquer, look for the answer
// O(nlogk), O(1)

/*
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // corner case
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeHelp(lists, 0, lists.length - 1);
        
    }
    
    public ListNode mergeHelp(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelp(lists, start, mid);
        ListNode right = mergeHelp(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        // corner case
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return dummy.next;
    }    
}
*/


// s3: use heap / priorityQueue
// O(k * n *log(k)), O(k)

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        Queue<ListNode> queue = new PriorityQueue<ListNode>();
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            queue.offer(lists[i]);
        }
        
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            if (temp != null) {
                node.next = temp;
                node = node.next;
                temp = temp.next;
                if (temp != null) {
                    queue.offer(temp);
                }
            }
        }
        return dummy.next;
    }
}


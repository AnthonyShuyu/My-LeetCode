/**
 * 
 * 138. Copy List with Random Pointer
 * 2 solutions
 * 
 */


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 
// s1: use hahsMap to map original node to the new node
// O(n), O(n)

/*
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = dummy;
        
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode newNode;
        while (head != null) {
            if (!hashMap.containsKey(head)) {
                newNode = new RandomListNode(head.label);
                hashMap.put(head, newNode);
            } else {
                newNode = hashMap.get(head);
            }
            node.next = newNode;
            
            if (head.random != null) {
                if (!hashMap.containsKey(head.random)) {
                    newNode.random = new RandomListNode(head.random.label);
                    hashMap.put(head.random, newNode.random);
                } else {
                    newNode.random = hashMap.get(head.random);
                }
            }
            node = node.next;
            head = head.next;
        }
        return dummy.next;
    }
}
*/


// s2: copy list and copy random to double the original list, then split the list
// O(n), O(1)

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // corner case
        if (head == null) {
            return null;
        }
        
        copyList(head);
        copyRandom(head);
        return split(head);
    }
    
    public void copyList(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            newNode.random = head.random;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    public void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    public RandomListNode split(RandomListNode head) {
        RandomListNode dummy1 = new RandomListNode(0);
        RandomListNode dummy2 = new RandomListNode(0);
        RandomListNode list1 = dummy1;
        RandomListNode list2 = dummy2;
        int n = 0;
        while (head != null) {
            if (n % 2 == 0) {
                list1.next = head;
                list1 = list1.next;
            } else {
                list2.next = head;
                list2 = list2.next;
            }
            head = head.next;
            n++;
        }
        
        // this is important, same as list1 or list2.next = null
        if (n % 2 == 0) {
            list1.next = head;
        } else {
            list2.next = head;
        }
        
        return dummy2.next;
    }
}

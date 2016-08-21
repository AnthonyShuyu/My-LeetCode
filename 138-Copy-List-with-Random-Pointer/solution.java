/**
 * 
 * 138. Copy List with Random Pointer
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
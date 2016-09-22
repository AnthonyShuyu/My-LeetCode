/**
 * 
 * 146. LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 */



// s1: use HashMap and use an arrayList to represent the LRU elements
// O(n), O(n)
// succeeded

/*
public class LRUCache {
    int capacity;
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    List<Integer> arrayList = new ArrayList<Integer>();
    int num = 0;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (hashMap.containsKey(key)) {
            updateList(key);
            return hashMap.get(key);
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        
        // if (num <= capacity && hashMap.containsKey(key)) {
        if (hashMap.containsKey(key)) {
            updateList(key);
            hashMap.put(key, value);
            return;
        }
        
        if (num >= capacity) {
            int old_key = arrayList.get(0);
            arrayList.remove(0);
            arrayList.add(key);
            hashMap.remove(old_key);
            hashMap.put(key, value);
        } else {
            arrayList.add(key);
            hashMap.put(key, value);
            num++;
        }
    }
    public void updateList(int key) {
        arrayList.remove(Integer.valueOf(key));
        arrayList.add(key);
    }
}
*/



// s2: use a HashMap and singly Linked List
// O(n), O(n)

public class LRUCache {
    
    
    private class ListNode {
        int value;
        ListNode next = null;
        public ListNode(int value) {
            this.value = value;
        }
    }
    
    int capacity;
    int num = 0;
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    ListNode listNode = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (capacity <= 0) {
            return -1;
        }
        
        if (hashMap.containsKey(key)) {
            updateListNode(key, listNode);
            return hashMap.get(key);
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        // corner case
        if (capacity <= 0) {
            return;
        }
        
        if (hashMap.containsKey(key)) {
            updateListNode(key, listNode);
            hashMap.put(key, value);
            return;
        }
        
        if (num < capacity) {
            appendToTail(key, listNode);
            hashMap.put(key, value);
            num++;
        } else {
            hashMap.remove(listNode.value);
            hashMap.put(key, value);
            removeHeadAndAppendToTail(key, listNode);
        }
        
        
    }
    
    public void updateListNode(int key, ListNode listNode) {
        ListNode node = listNode;
        if (key == node.value) {
            removeHeadAndAppendToTail(key, listNode);
        } else {
            while (node != null) {
                if (node.next.value == key) {
                    node.next = node.next.next;
                    break;
                } else {
                    node = node.next;
                }               
            }
            appendToTail(key, listNode);
        }
    }
    
    public void appendToTail(int key, ListNode listNode) {
        ListNode node = new ListNode(key);
        if (listNode == null) {
            listNode = node;
        } else {
            ListNode tail = findTheTailNode(listNode);
            tail.next = node;
        }
    }
    
    public void removeHeadAndAppendToTail(int key, ListNode listNode) {
        appendToTail(key, listNode);
        // ListNode dummy = new ListNode(0);
        // dummy.next = listNode;
        listNode = listNode.next;
        
    }
    
    public ListNode findTheTailNode(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        return listNode;
    }
    
    
    

}
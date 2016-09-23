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
            // System.out.println("The old key is: " + old_key);
            // updateList(old_key);
            // appendToList(key);   // remove the first at the same time
            hashMap.remove(old_key);
            hashMap.put(key, value);
        } else {
            arrayList.add(key);
            hashMap.put(key, value);
            num++;
        }
    }
    public void updateList(int key) {
        // System.out.println("the key is: " + key);
        arrayList.remove(Integer.valueOf(key));
        // System.out.println("The arrayList is : " + arrayList);
        arrayList.add(key);
    }
    
    // public void appendToList(int key) {
    //     arrayList.remove(0);
    //     arrayList.add(key);
    // }
}
*/


// s2: use a HashMap and singly Linked List
// O(n), O(n)
// time limit exceeded

/*
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
            updateListNode(key);
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
            updateListNode(key);
            hashMap.put(key, value);
            return;
        }
        
        if (num < capacity) {
            appendToTail(key);
            hashMap.put(key, value);
            num++;
        } else {
            hashMap.remove(listNode.value);
            hashMap.put(key, value);
            removeHeadAndAppendToTail(key);
        }
    }
    
    public void updateListNode(int key) {
        ListNode node = listNode;
        if (key == node.value) {
            removeHeadAndAppendToTail(key);
        } else {
            while (node != null && node.next != null) {
                if (node.next.value == key) {
                    node.next = node.next.next;
                    break;
                } else {
                    node = node.next;
                }               
            }
            appendToTail(key);
        }
    }
    
    public void appendToTail(int key) {
        ListNode node = new ListNode(key);
        if (listNode == null) {
            listNode = node;
        } else {
            ListNode tail = findTheTailNode(listNode);
            tail.next = node;
        }
    }
    
    public void removeHeadAndAppendToTail(int key) {
        appendToTail(key);
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

*/

// s3: use a HashMap and a doubly linked list

public class LRUCache {
    
    private class ListNode {
        int value;
        ListNode prev;
        ListNode post;
        public ListNode(int value) {
            this.value = value;
        }
    }
    
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    ListNode listNode = null;
    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    int num = 0;
    
    public int get(int key) {
        if (hashMap.containsKey(key)) {
            updateLinkedList(key);
            return hashMap.get(key);
        } else {
            return -1;
        }
        
    }
    
    public void set(int key, int value) {
        if (hashMap.containsKey(key)) {
            hashMap.put(key, value);
            updateLinkedList(key);
            return;
        }
        
        if (num < capacity) {
            hashMap.put(key, value);
            appendToTail(key);
            num++;
        } else {
            int old_key = listNode.value;
            hashMap.remove(old_key);
            hashMap.put(key, value);
            removeFirstAndAppendToTail(key);
        }
    }
    
    public void updateLinkedList(int key) {
        ListNode node = listNode;
        while (node != null) {
            if (node.value == key) {
                node.prev.post = node.post;
                node.post.prev = node.prev;
            } else {
                node = node.post;
            }
        }
        appendToTail(key);
    }
    
    public void appendToTail(int key) {
        ListNode newNode = new ListNode(key);
        if (listNode == null) {
            listNode = newNode;
            return;
        }
        ListNode node = listNode;
        
        while (node != null && node.post != null) {
            node = node.post;
        }
        node.post = newNode;
        newNode.prev = node;
    }
    
    public void removeFirstAndAppendToTail(int key) {
        listNode.post.prev = null;
        listNode = listNode.post;
        appendToTail(key);
    }
}    

/**
 * 
 * 146. LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 */



// s1: use HashMap and use an arrayList to represent the LRU elements
// O(n), O(n)
// time limit exceeded

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
        
        if (num <= capacity && hashMap.containsKey(key)) {
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
/**
 * 
 * 
 * 208. Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * 
 */

// s1: use HashMap
// O(n), O(n)
// ticky,  Map<Character, TrieNode> hashMap = new HashMap<Character, TrieNode>();

/*
class TrieNode {
    // Initialize your data structure here.
    char c;
    Map<Character, TrieNode> hashMap = new HashMap<Character, TrieNode>();
    boolean hasWord;
    public TrieNode() {
    }
    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.hashMap.containsKey(word.charAt(i))) {
                TrieNode old_node = node.hashMap.get(word.charAt(i));
                node = old_node;
            } else {
                TrieNode new_node = new TrieNode(word.charAt(i));
                node.hashMap.put(word.charAt(i), new_node);
                node = new_node;
            }
        }
        node.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.hashMap.containsKey(word.charAt(i))) {
                return false;
            } else {
                node = node.hashMap.get(word.charAt(i));
            }
        }
        if (node.hasWord) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.hashMap.containsKey(prefix.charAt(i))) {
                return false;
            } else {
                node = node.hashMap.get(prefix.charAt(i));
            }
        }
            return true;
    }
}
*/


// s2*: hashMap again, but create another mothod to reduce code duplicates
// O(n), O(n)
// tricky

class TrieNode {
    char c;
    Map<Character, TrieNode> hashMap = new HashMap<Character, TrieNode>();
    boolean hasWord;
    public TrieNode() {
    }
    public TrieNode(char c) {
        this.c = c;
    }
    
}

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.hashMap.containsKey(c) {
                node = node.hashMap.get(c);
            } else {
                TrieNode new_node = new TrieNode(c);
                node.hashMap.put(c, new_node);
                node = new_node;
            }
        }
        node.hasWord = true;
    }
    
    public boolean search(String s) {
        TrieNode node = searchPos(s);
        if (node == null || !node.hasWord) {
            return false;
        } 
        return true;
    }
    
    public boolean startsWith(String s) {
        TrieNode node = searchPos(s);
        if (node == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public TrieNode searchPos(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.hashMap.containsKey(c)) {
                return null;
            } else {
                node = node.hashMap.get(c);
            }
        }
        return node;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
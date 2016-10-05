/**
 * 
 * 
 * 208. Implement Trie (Prefix Tree)
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * 
 */



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

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
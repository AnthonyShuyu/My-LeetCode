/**
 * 
 * 211. Add and Search Word - Data structure design
 * 
 * 
 */
 
 
// s1: use Trie, recursion
// O(n), O(n)


class TrieNode {
    char c;
    boolean hasWord;
    Map<Character, TrieNode> hashMap = new HashMap<Character, TrieNode>();
    public TrieNode() {
        
    }
    public TrieNode(char c) {
        this.c = c;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            if (node.hashMap.containsKey(s.charAt(i))) {
                node = node.hashMap.get(s.charAt(i));
            } else {
                TrieNode new_node = new TrieNode(s.charAt(i));
                node.hashMap.put(s.charAt(i), new_node);
                node = new_node;
            }
        }
        node.hasWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = searchWordPos(word);
        if (node == null || !node.hasWord) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean startsWith(String word) {
        TrieNode node = searchWordPos(word);
        return node != null;
    }
    
    public TrieNode searchWordPos(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.hashMap.containsKey(c)) {
                return null;
            } else {
                node = node.hashMap.get(c);
            }
        }
        return node;
    }
}

public class WordDictionary {
    Trie t = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        t.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode node = t.root;
        // corner case
        if (word == null || word.length() == 0) {
            return false;
        }
        return searchWord(word, 0, node);
    }
    
    public boolean searchWord(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        
        if (c != '.') {
            if (!node.hashMap.containsKey(c)) {
                return false;
            } else {
                node = node.hashMap.get(c);
                return searchWord(word, index + 1, node);                
            }
        } else {
            if (index == word.length() - 1) {
                return true;
            }
            boolean result = false;
            for (Trie value: node.hashMap.values()) {
                result = result || searchWord(word, index + 1, value);
            }
            return result;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
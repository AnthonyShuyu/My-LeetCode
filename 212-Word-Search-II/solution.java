/**
 * 212. Word Search II
 * 
 */

// s1: recursion, find the word one by one
// O(m^2 * n), O(n)
// time limit exceeded

/*
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        // corner 
        if (board == null || board.length == 0) {
            return result;
        }
        if (board[0] == null || board[0].length == 0) {
            return result;
        }
        if (words == null || words.length == 0) {
            return result;
        }
        
        for (String s : words) {
            if (exist(board, s)) {
                if (!result.contains(s)) {
                    result.add(s);
                }
            }
        }
        return result;
    }
    
    public boolean exist(char[][] board, String s) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == s.charAt(0)) {
                    boolean result = find(board, s, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, String s, int i, int j, int start) {
        if (start == s.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != s.charAt(start)) {
            return false;
        }
        board[i][j] = '#';
        boolean result = find(board, s, i + 1, j, start + 1) || find(board, s, i - 1, j, start + 1) || find(board, s, i, j + 1, start + 1) || find(board, s, i, j - 1, start + 1);
        board[i][j] = s.charAt(start);
        return result;
    }
}
*/

// s1 again: recursion dfs, find the word one by one
// O(m * n * k), O(n)
// time limit exceeded

/*
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        // corner case
        if (board == null || board.length == 0) {
            return result;
        }
        if (board[0] == null || board[0].length == 0) {
            return result;
        }
        if (words == null || words.length == 0) {
            return result;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0 && find(board, words[i])) {
                if (!result.contains(words[i])) {
                    result.add(words[i]);
                }
            }
        }
        return result;
    }
    
    public boolean find(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (checkWord(board, i, j, word, index)) {
                        return true;
                    }                    
                }
            }
        }
        return false;
    }
    
    public boolean checkWord(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        
        if (board[x][y] == word.charAt(index)) {
            board[x][y] = '#';                      // tricky, to avoid repeated traverse
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            boolean result = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                result = result || checkWord(board, nx, ny, word, index + 1);
            }
            board[x][y] = word.charAt(index); // don't forget to put back the original char
            return result;            
        } else {
            return false;
        }
    }
}    
*/


// s2: use Trie + dfs
// O(n * m * k), O(k)
// tricky, 1. to get the result, pass the result as the parameters; 2. String will not be changed as parameters in methods

// implement Trie first
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

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.hashMap.containsKey(c)) {
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


public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        
        Trie t = new Trie();
        for (int i = 0; i < words.length; i++) {
            t.insert(words[i]);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String s = "";
                // String string = find(t, board, i, j, s);
                // if (string != null) {
                //     if (!result.contains(string)) {
                //         result.add(string);
                //     }
                // }    
                find(t, board, i, j, s, result);
            }
        }
        return result;
    }
    
    // !!! the String will not change when passed as the parameters of 
    public void find(Trie t, char[][] board, int i, int j, String s, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        s = s + c;
        if (!t.startsWith(s)) {
            return;
        }
        if (t.search(s)) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }    
            board[i][j] = '#';
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                find(t, board, nx, ny, s, result);
            }
            board[i][j] = c;
            // return new_s;
    }
}    
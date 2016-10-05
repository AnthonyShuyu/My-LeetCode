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
// O(m * n * k), O(1)

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
                result.add(words[i]);
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
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (board[x][y] == word.charAt(index)) {
            char[x][y] = '#';
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            boolean result = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                result = result || checkWord(board, nx, ny, word, index + 1);
            }
            return result;            
        } else {
            return false;
        }
        
        
    }
}    
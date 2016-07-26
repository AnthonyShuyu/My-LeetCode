/**
 * 212. Word Search II
 * 
 */

// s1: recursion, find the word one by one
// O(m^2 * n), O(n)

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
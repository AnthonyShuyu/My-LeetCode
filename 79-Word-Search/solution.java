/**
 * 79. Word Search
 * For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * 
 */

// *s1: recursion
// O(), O()
// tricky

public class Solution {
    public boolean exist(char[][] board, String word) {
        // corner case
        if (board == null || board.length == 0) {
            return false;
        }
        if (board[0] == null || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = find(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, String word, int i, int j, int start) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }
        board[i][j] = '#';
        boolean result = find(board, word, i + 1, j, start + 1) || find(board, word, i - 1, j, start + 1) || find(borad, word, i, j + 1, start + 1) || find(board, word, i, j - 1, start + 1);
        // board[i][j] = word.charAt(start);
        return result;
    }
}
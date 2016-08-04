/**
 * 36. Valid Sudoku
 * 
 * 
 */

// s1: brute force
// O(n^2), O(n^2)

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }
        if (board[0] == null || board[0].length != 9) {
            return false;
        }
        
        // rows
        for (int i = 0; i < 9; i++) {
            if (!validNums(board[i])) {
                return false;
            }
        }
        
        // columns
        for (int i = 0; i < 9; i++) {
            char[] nums = new int[9];
            for (int j = 0; j < 9; j++) {
                nums[j] = board[j][i];
            }
            if (!validNums(nums)) {
                return false;
            }
        }
        
        // 9 boxes
        for (int i = 0; i < 3; i++) {
            char[] nums = new int[9];
            for (int j = 0; j < 3; j++) {
                nums[0] = board[0 + 3 * i][0 + 3 * j];
                nums[1] = board[0 + 3 * i][1 + 3 * j];
                nums[2] = board[0 + 3 * i][2 + 3 * j];
                nums[3] = board[1 + 3 * i][0 + 3 * j];
                nums[4] = board[1 + 3 * i][1 + 3 * j];
                nums[5] = board[1 + 3 * i][2 + 3 * j];
                nums[6] = board[2 + 3 * i][0 + 3 * j];
                nums[7] = board[2 + 3 * i][1 + 3 * j];
                nums[8] = board[2 + 3 * i][2 + 3 * j];
            }
            if (!validNums(nums)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validNums(char[] nums) {
        if (nums == null || nums.length != 9) {
            return false;
        }
        Set<Character> hashSet = new HashSet<Character>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '.') {
                continue;
            }
            if (nums[i] > '9' || nums[i] < '1') {
                return false;
            } else if (hashSet.contains(nums[i])){
                return false;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return true;
    }
}
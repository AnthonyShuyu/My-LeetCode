/**
 * 
 * 292. Nim Game
 * 
 * 
 */


// s1: dp
// O(n), O(n)

public class Solution {
    public boolean canWinNim(int n) {
        // corner case
        if (n < 0) {
            return false;
        }
        // boolean[] result = new boolean[n];
        // if (n == 1) {
        //     return true;
        // }
        // if (n == 2) {
        //     return true;
        // }
        // if (n == 3) {
        //     return true;
        // }
        // result[0] = true;
        // result[1] = true;
        // result[2] = true;
        // for (int i = 3; i < n; i++) {
        //     if (!result[i - 1] || !result[i - 3] || !result[i - 2]) {
        //         result[i] = true;
        //     }
        // }
        // return result[n - 1];
        int num = n % 4;
        if (num == 0) {
            return false;
        } else {
            return true;
        }
    }
}
/**
 * 
 * 7. Reverse Integer
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 * 
 * 2 solutions
 */

// s1: brute force, use num * 10 + num;
// O(n), O(1)

/*
public class Solution {
    public int reverse(int x) {
        // corner case
        if (x == Integer.MAX_VALUE) {
            return 0;
        } else if (x == Integer.MIN_VALUE) {
            return 0;
        }
        
        // int sign = 1;
        // if (x < 0) {
        //     sign = -1;
        //     x = x * -1;
        // }
        int num = x > 0 ? x : -x;
        int digit = 0;
        long new_num = 0;
        while (num > 0) {
            new_num = new_num * 10 + num % 10;
            if (new_num >= Integer.MAX_VALUE) {
                new_num = 0;
                break;
            } 
            num /= 10;
        }
        return x > 0 ? (int)new_num : (int)(-new_num);
        
    }
}
*/

// *s2: brute force, use num * 10 + num
// O(n), O(1)
// tricky, don't need to do negative check

public class Solution {
    public int reverse(int x) {
        // corner case
        
        int result = 0;
        int num = x;
        while (num != 0) {
            int temp = result * 10 + num % 10;
            if (temp / 10 != result) {
                result = 0;
                break;
            }
            num /= 10;
            result = temp;
        }
        return result;
    }
}

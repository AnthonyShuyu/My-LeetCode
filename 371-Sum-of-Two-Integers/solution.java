/**
 * 371. Sum of Two Integers
 * 
 * 
 */
 

// s1: bit operation, Given two numbers a and b, a&b returns the number formed by '1' bits on a and b. When it is left shifted by 1 bit, it is the carry.
//For example, given a=101 and b=111 (in binary), the a&b=101. a&b << 1 = 1010.
//a^b is the number formed by different bits of a and b. a&b=10. 
// O(n), O(1)
// tricky

public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}
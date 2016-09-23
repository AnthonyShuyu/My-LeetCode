/**
 * 263. Ugly Number
 * 
 * 
 */


// s1: brute force, divide 2,3,5 for many times and stop when finally get 1
// O(n), O(1)

/*
public class Solution {
    public boolean isUgly(int num) {
        // corner case
        if (num <= 0) {
            return false;
        }
                
        while (num != 1) {
            if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
                return false;
            } else if (num % 2 == 0){
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            }
        }
        return true;
    }
}
*/


// *s2: divide 2, 3, 5 respectively
// O(n), O(1)

public class Solution {
    public boolean isUgly(int num) {
        // corner case
        if (num <= 0) {
            return false;
        }
        
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        return num == 1;
    }
}


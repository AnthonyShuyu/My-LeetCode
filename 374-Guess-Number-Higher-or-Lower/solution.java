/**
 * 
 * 374. Guess Number Higher or Lower
 * 
 * 
 */


/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */


// s1: binary search
// O(logn), o(1)

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        //corner case
        if (n <= 0) {
            return 0;
        }
        
        int start = 1;
        int end = n;
        
        while (start + 1 < n) {
            int mid = start + (end - start) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid;
            } else if (guess(mid) == -1) {
                end = mid;
            } else {
                return 0;
            }
        }
        
        if (guess(start) == 0) {
            return start;
        } else {
            return end;
        }
        
    }
}
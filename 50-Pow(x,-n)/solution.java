/**
 * 
 * 
 * 50. Pow(x, n)
 * 
 * 
 */

// public class Solution {
//     public double myPow(double x, int n) {
//         // corner case
//         if (n == 0) {
//             return 1;
//         }
//         if (n == 1) {
//             return x;
//         }
//         boolean isPositive = true;;
//         if (n < 0) {
//             isPositive = false;
//             n = (-1) * n;
//         }
//         double num = 0;
//         // if (n % 2 == 0) {
//         //     num = myPow(x, n / 2) * myPow(x, n / 2);
//         // } else {
//         //     num = myPow(x, n / 2) * myPow(x, n / 2) * x;
//         // }
//         int k = n / 2;
//         int l = n - k * 2;
//         double t1 = myPow(x, k);
//         double t2 = myPow(x, l);
//         num = t1 * t1 * t2;
//         // num = myPow(x, k) * myPow(x, k) * myPow(x, l);
        
//         if (isPositive) {
//             return num;
//         } else {
//             return 1 / num;
//         }
//     }
// }

public class Solution {
    public double myPow(double x, int n) {
        
        long n = n;
        
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = n * -1;
        }
        
        int k = n / 2;
        int l = n - k * 2;
        
        double t1 = myPow(x, k);
        double t2 = myPow(x, l);
        
        double t = t1 * t1 * t2;
        return isNegative? (1/t) : t;
        
    }
}
/**
 * 
 * 
 * 50. Pow(x, n)
 * 
 * 
 */

public class Solution {
    public double myPow(double x, int n) {
        // corner case
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        long n1 = n;
        
        boolean isPositive = true;;
        if (n1 < 0) {
            isPositive = false;
            n1 = (-1) * n1;
        }
        double num = 0;
        
        double t = myPow(x, (int)n1 / 2);
        
        if (n1 % 2 == 0) {
            num = t1 * t1;
        } else {
            num = t1 * t1 * x;
        }
        // int k = n / 2;
        // int l = n - k * 2;
        // double t1 = myPow(x, k);
        // double t2 = myPow(x, l);
        // num = t1 * t1 * t2;
        // num = myPow(x, k) * myPow(x, k) * myPow(x, l);
        
        if (isPositive) {
            return num;
        } else {
            return 1 / num;
        }
    }
}


/*
public class Solution {
    public double myPow(double x, int n) {
        
        long n1 = n;
        
        if (n1 == 0) {
            return 1;
        }
        if (n1 == 1) {
            return x;
        }
        
        boolean isNegative = false;
        if (n1 < 0) {
            isNegative = true;
            n1 = n1 * -1;
        }
        
        int k = (int)(n1 / 2);
        int l = (int)(n1 - k * 2);
        
        double t1 = myPow(x, k);
        double t2 = myPow(x, l);
        
        double t = t1 * t1 * t2;
        return isNegative? (1/t) : t;
        
    }
}
*/
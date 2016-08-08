/**
 * 
 * 166. Fraction to Recurring Decimal
 * 
 * 
 */ 



public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // corner case
        if (denominator == 0) {
            return null;
        }
        int factor = numerator / denominator;
        int remainder = numerator % denominator;
        
        if (factor > 0 && remainder == 0) {
            return factor;
        }
        
    }
}
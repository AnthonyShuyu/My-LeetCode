/**
 * 
 * 166. Fraction to Recurring Decimal
 * 1 solution
 * 
 */ 

// s1: hashMap
// O(n), O(n)
// failed

/*
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // corner case
        StringBuilder sb = new StringBuilder();
        
        if (denominator == 0) {
            return null;
        }
        int factor = numerator / denominator;
        int remainder = numerator % denominator;
        
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int index = 0;
        
        if (factor > 0 && remainder == 0) {
            sb.append(factor);
            return sb.toString();
        } else {
            if (factor > 0) {
                sb.append(factor);
                sb.append(".");
            } else if (factor == 0) {
                sb.append(0);
                sb.append(".");
            }
            while (factor == 0 || remainder > 0) {
                    factor = remainder * 10 / denominator;
                    if (hashMap.containsKey(factor)) {
                        sb.insert(hashMap.get(factor) + 2, "(");
                        sb.append(")");
                        break;
                    }
                    hashMap.put(factor, index);
                    index++;
                    sb.append(factor);
                    remainder = remainder % denominator * 10;
                    
            }
        }
        
        return sb.toString();
    }
}
*/


// s1: HashMap
// O(n), O(n)

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
           // corner case
           if (denominator == 0) {
               return "";
           }
           if (numerator == 0) {
               return "0";
           }
           StringBuilder sb = new StringBuilder();
           if ((numerator < 0) ^ (denominator < 0)) {
               sb.append("-");
           }
           
        //   long num = Math.abs(numerator);
        //   long den = Math.abs(denominator);
           long num = numerator;
           long den = denominator;
           num = Math.abs(num);
           den = Math.abs(den);
           
           
            // get the left of "."
           long factor = num / den;
           long remainder = num % den * 10;
           sb.append(factor);
           
           if (remainder == 0) {
               return sb.toString();
           }
           sb.append(".");
           
           // get the right of "."
           Map<Long, Integer> hashMap = new HashMap<Long, Integer>();
           
           while (remainder != 0) {
               if (hashMap.containsKey(remainder)) {
                   int index = hashMap.get(remainder);
                   String part1 = sb.substring(0, index).toString();
                    String part2 = sb.substring(index, sb.length()).toString();
                    // return part1 + "(" + part2 + ")";                   
                    sb = new StringBuilder();
                    sb.append(part1 + "(" + part2 + ")");
                    return sb.toString();
               }
               hashMap.put(remainder, sb.length());
               factor = remainder / den;
               sb.append(factor);
               remainder = remainder % den * 10;
           }
           return sb.toString();
    }
}
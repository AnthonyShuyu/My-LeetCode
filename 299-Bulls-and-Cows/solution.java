/**
 * 299. Bulls and Cows
 * 
 * 
 */


// s1: HashMap
// O(n), O(n)

/*  
public class Solution {
    public String getHint(String secret, String guess) {
        // corner case
        String result = "";
        if (secret == null || secret.length() == 0) {
            return result;
        }
        if (guess == null || guess.length() == 0) {
            return result;
        }
        if (secret.length() != guess.length()) {
            return result;
        }
        int countA = 0;
        int count = 0;
        
        // countA
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            }
        }
        
        // countA + countB, use the HashMap to store the value and count of the number
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if(hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (hashMap.containsKey(c) && hashMap.get(c) > 0) {
                count++;
                hashMap.put(c, hashMap.get(c) - 1);
            }
        }
        
        int countB = count - countA;
        
        StringBuilder sb = new StringBuilder();
        sb.append(countA + "A" + countB + "B");
        return sb.toString();
    }
}
*/

// *s2: optimize HashMap
// O(n), O(n)

/*
public class Solution {
    public String getHint(String secret, String guess) {
        // corner case

        if (secret == null || secret.length() == 0) {
            return null;
        }
        if (guess == null || guess.length() == 0) {
            return null;
        }
        if (secret.length() != guess.length()) {
            return null;
        }
        
        // get bulls and use HashMap to store secret value map to the count of the value
        int countA = 0;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                countA++;
            } else {
                if (hashMap.containsKey(c1)) {
                    hashMap.put(c1, hashMap.get(c1) + 1);
                } else {
                    hashMap.put(c1, 1);
                }
            }
        }
        
        // get cows
        int countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 != c2) {
                if (hashMap.containsKey(c2) && hashMap.get(c2) > 0) {
                    countB++;
                    hashMap.put(c2, hashMap.get(c2) - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(countA + "A" + countB + "B");
        return sb.toString();
                
    }
}
*/


// s3: use Array
// O(n), O(n)

public class Solution {
    public String getHint(String secret, String guess) {
        // corner case
        if (secret == null || secret.length() == 0) {
            return null;
        }
        if (guess == null || guess.length() == 0) {
            return null;
        }
        if (secret.length() != guess.length()) {
            return null;
        }
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        
        int countA = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                countA++;
            } else {
                a1[c1 - '0']++;
                a2[c2 - '0']++;
            }
        }
        
        int countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            countB += Math.min(a1[i], a2[i]);
        }
        return countA + "A" + countB + "B";
        
    }
}
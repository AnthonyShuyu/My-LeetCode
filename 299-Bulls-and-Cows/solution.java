/**
 * 299. Bulls and Cows
 * 
 * 
 */


// s1: HashMap
// O(n), O(n)


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
            if(hashMap.containskey(c)) {
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
        
        // // use hashMap to store index and value
        // Map<Integer, Character> hashMap = new HashMap<Integer, Character>();
        
        // // use hashSet to store the different cows
        // // Set<Character> hashSet = new HashSet<Character>();
        
        // for (int i = 0; i < secret.length(); i++) {
        //     hashMap.put(i, secret.charAt(i));
        // }
        
        // for (int i = 0; i < guess.length(); i++) {
        //     if (hashMap.containsKey(i)) {
        //         if (hashMap.get(i) == guess.charAt(i)) {
        //             countA++;
        //         } else {
        //             if (hashMap.containsValue(guess.charAt(i))) {
        //                 // if (!hashSet.contains(guess.charAt(i))) {
        //                     countB++;
        //                     // hashSet.add(guess.charAt(i));
        //                 }
        //             }
        //         }
        //     }
        
        StringBuilder sb = new StringBuilder();
        sb.append(countA + "A" + countB + "B");
        return sb.toString();
    }
}
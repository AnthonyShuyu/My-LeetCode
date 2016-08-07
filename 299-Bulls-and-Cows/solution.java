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
        int countB = 0;
        
        // use hashMap to store index and value
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            hashMap.put(i, secret.charAt(i));
        }
        
        for (int i = 0; i < guess.length(); i++) {
            if (hashMap.containsKey(i)) {
                if (hashMap.get(i) == guess.charAt(i)) {
                    countA++;
                } else {
                    if (hashMap.containsValue(guess.charAt(i))) {
                        countB++;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(countA + "A" + countB + "B");
        return sb.toString();
        
    }
}
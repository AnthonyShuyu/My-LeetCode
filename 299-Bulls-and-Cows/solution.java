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
        Map<Integer, Character> hashMap = new HashMap<Integer, Character>();
        
        // use hashSet to store the different cows
        Set<Character> hashSet = new HashSet<Character>();
        
        for (int i = 0; i < secret.length(); i++) {
            hashMap.put(i, secret.charAt(i));
        }
        
        for (int i = 0; i < guess.length(); i++) {
            if (hashMap.containsKey(i)) {
                if (hashMap.get(i) == guess.charAt(i)) {
                    countA++;
                } else {
                    if (hashMap.containsValue(guess.charAt(i))) {
                        // if (!hashSet.contains(guess.charAt(i))) {
                            countB++;
                            // hashSet.add(guess.charAt(i));
                        }
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(countA + "A" + countB + "B");
        return sb.toString();
    }
}
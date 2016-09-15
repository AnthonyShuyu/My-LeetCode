/**
 * 
 * 383. Ransom Note
 * 
 * 
 */ 


// s1: use an array
// O(n), O(1)

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // corner case
        if (ransomNote == null || magazine == null) {
            return false;
        }
        int count = ransomNote.length();
        if (count == 0) {
            return true;
        }
        int[] array = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            array[index]++;
        }
        
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            if (array[index] > 0) {
                array[index]--;
                count--;
                if (count == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
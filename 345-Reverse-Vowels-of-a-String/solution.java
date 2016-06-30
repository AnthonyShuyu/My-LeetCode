/* 
* Reverse Vowels of a String
* A, E, I, O, U are 5 vowels in a String
* Ask questions: What are the characters in the String?
* Assume: characters in the String are all lower case letters
*
*/

// 

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            while (!isVowel(charArray[start]) && start < charArray.length) {
                start++;
            }
            while (!isVowel(charArray[end]) && end >= 0) {
                end--;
            }
            swap(charArray, start, end);
            start++;
            end--;
        }
        return String.valueOf(charArray);
    }
    
    public void swap(char[] charArray, int start, int end) {
        if (start >= end) {
            return;
        }
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
    }
    
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
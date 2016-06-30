/* 
* Reverse Vowels of a String
* 2 methods
*
* A, E, I, O, U are 5 vowels in a String
* Ask questions: What are the characters in the String?
* Assume: characters in the String are all lower case letters
*
*/

// s1: use 2 pointers
// O(n^2), O(n)

/*
public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            while (start < charArray.length && !isVowel(charArray[start])) {
                start++;
            }
            while (end >= 0 && !isVowel(charArray[end]) ) {
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
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
*/


// s2: use another array to store the positions of vowels 
// O(n), O(n)

public class Solution{
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<Character> hashSet = new HashSet<Character>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');
        
        char[] pos = new char[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashSet.contains(s.charAt(i))) {
                pos[count] = i;
                count++;
            }
        }
        
        char[] charArray = s.toCharArray();
        for (int i = 0; i < count; i++) {
            charArray[pos[i]] == s.charAt(count - i - 1);
        }
        return String.valueOf(charArray);
    }
}


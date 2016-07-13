/**
 * 
 * 76. Minimum Window Substring
 * 
 * 
 */

// s1: brute force
// O(n^3), O(n^2)
// time limit exceeded 

/*
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }    
        if (s.length() < t.length()) {
            return "";
        }
        for (int i = t.length(); i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i ; j++) {
                if (checkContains(s.substring(j, j + i), t)) {
                    return s.substring(j, j + i);
                }
            }
        } 
        return "";
    }
    
    public boolean checkContains(String s1, String s2) {
        int[] arr = new int[58]; // 'z' - 'A' + 1
        for (int i = 0; i < s1.length(); i++) {
            arr[(int)s1.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[(int)s2.charAt(i) - 65] -= 1;
            if (arr[(int)s2.charAt(i) - 65] < 0) {
                return false;
            }
        }
        return true;
    }
}
*/


// s2: brute force, use a little tricky
// O(n^3), O(n^2)
// time limit exceeded


/*
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int j = 0;
        String temp = "";
        int min = s.length() + 1;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !checkContains(temp, t)) {
                temp = s.substring(i, j + 1);
                j++;
            }
            if (checkContains(temp, t)) {
                if (temp.length() < min) {
                    result = temp;   
                    min = temp.length();
                }
                temp = s.substring(i + 1, j);
            }
        }
        return result;        
    }
    
    public boolean checkContains(String s1, String s2) {
        int[] arr = new int[58]; // 'z' - 'A' + 1
        for (int i = 0; i < s1.length(); i++) {
            arr[(int)s1.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[(int)s2.charAt(i) - 65] -= 1;
            if (arr[(int)s2.charAt(i) - 65] < 0) {
                return false;
            }
        }
        return true;
    }
}

*/

// s3: 




public class Solution {
    //方法一:
    int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
    boolean valid(int []sourcehash, int []targethash) {
        
        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])    
                return false;
        }
        return true;
    }
    public String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        
        initTargetHash(targethash, Target);
        int j = 0, i = 0;
        for(i = 0; i < Source.length(); i++) {
            
            while( !valid(sourcehash, targethash) && j < Source.length()  ) {
                sourcehash[Source.charAt(j)]++;
                if(j < Source.length() )
                    j++;
                else 
                    break;
            }
            if(valid(sourcehash, targethash) ){
                if(ans > j - i ) {
                    ans = Math.min(ans, j - i );
                    minStr = Source.substring(i, j );
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }
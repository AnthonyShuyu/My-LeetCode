public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int leftBound = 0;

        if (s==null||s.isEmpty()) {
            length = 0;
        }

        Set<Character> hashSet = new HashSet<Character>(2,1.0f);

        for (int i=0; i<s.length() ;i++) {
            if (hashSet.contains(s.charAt(i))) {
                while (s.charAt(leftBound) != s.charAt(i)) {
                    hashSet.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            } else {
                hashSet.add(s.charAt(i));
                length = Math.max(length,i-leftBound+1);
            }
        }
        return length;
    }

}

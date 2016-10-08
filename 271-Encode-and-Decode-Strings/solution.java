/**
 * 
 * 
 * 271. Encode and Decode Strings
 * 
 * 
 * 
 */


// s1: use a number and a sign to represent the length of a String and the start of String
// O(n), O(1)
// tricky

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            int length = s.length();
            sb.append(length + "|" + s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        int i  = 0;
        List<String> list = new ArrayList<String>();

        while (i < s.length()) {
            int length = 0;
            while (s.charAt(i) != '|') {
                length = length * 10 + (s.charAt(i) - '0');
                i++;
            }
            String s = s.substring(i + 1, i + 1 + length);
            list.add(s);
            i = i + length + 1;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
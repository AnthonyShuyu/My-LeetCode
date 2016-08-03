/**
 * 
 * 71. Simplify Path
 * 
 * 
 */



// s1: regular expression, path.split("/+")
// O(n), O(n)

public class Solution {
    public String simplifyPath(String path) {
        // corner case
        if (path == null || path.length() == 0) {
            return path;
        }        
        
        String result = "/";
        String[] strs = path.split("/+");
        List<String> arrayList = new ArrayList<String>();
        
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..")) {
                if (arrayList.size() > 0) {
                    arrayList.remove(arrayList.size() - 1);
                }
            } else if (!str[i].equals(".")){
                arrayList.add(strs[i]);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            result += arrayList.get(i) + "/";
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}

/*
public class Solution {
    public String simplifyPath(String path) {
        // corner case
        if (path == null || path.length() == 0) {
            return path;
        }
        
        // solve the problem of duplicated "/"
        StringBuilder newpath = new StringBuilder();
        newpath.append(path.charAt(0));
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/' && path.charAt(i - 1) == '/') {
                continue;
            } else {
                newpath.append(path.charAt(i));
            }
        } 
        
        path = newpath.toString();
        // if (path.equals("/")) {
        //     return "/";
        // }
        // List<String> arrayList = new ArrayList<String>();
        // int index = path.length() - 1;
        // while (index >=  0) {
        //     if (path.charAt(index) == '.') {
        //         break;
        //     }
        //     if (Character.isDigit(path.charAt(index))) {
        //         int j = index - 1;
        //         while (j >= 0) {
        //             if (Character.isDigit(path.charAt(j))) {
        //                 j--;
        //             } else {
        //                 break;
        //             }
        //         }
        //         if (j >= 0) {
        //             String subpath = path.substring(j, index + 1);
        //             subpath += "/";
        //             arrayList.add(subpath);
        //         }
        //         index = j;
        //     }
        //     index--;
        // }
        
        int index = path.length() - 1;
        while (index >= 0) {
            if (Character.isLetter(path.charAt(index))) {
                break;
            } else {
                index--;
            }
        }
        int end = index;
        while (index >= 0) {
            if (path.charAt(index) == '.') {
                break;
            } else {
                index--;
            }
        }
        int start = index;
        String str = path.substring(start + 1, end + 1);
        int count = countSlash(path);
        

        if ((str.length() == 0 && count > 1) || path.equals("/.")) {
            return "/";
        } else if (str.length() == 0) {
            return path;
        } else {
            return str;
        }
    }
    
    public int countSlash(String path) {
        int result = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                result++;
            }
        }
        return result;
    }
}

*/
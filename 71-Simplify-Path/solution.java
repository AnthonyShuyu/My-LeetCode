/**
 * 
 * 71. Simplify Path
 * 
 * 
 */


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
        if (path.equals("/")) {
            return "/";
        }
        List<String> arrayList = new ArrayList<String>();
        int index = path.length() - 1;
        while (index >=  0) {
            if (path.charAt(index) == '.') {
                break;
            }
            if (Character.isDigit(path.charAt(index))) {
                int j = index - 1;
                while (j >= 0) {
                    if (Character.isDigit(path.charAt(j))) {
                        j--;
                    } else {
                        break;
                    }
                }
                if (j >= 0) {
                    String subpath = path.substring(j, index + 1);
                    subpath += "/";
                    arrayList.add(subpath);
                }
                index = j;
            }
            index--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = arrayList.size(); i >= 0; i--) {
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }
}
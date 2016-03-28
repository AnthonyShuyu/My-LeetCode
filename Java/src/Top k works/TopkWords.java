/**
* Find the top k words appeared given a sentence
*
*/

// use HashMap, ArrayList and Arrays.sort() method, T = O(nlogn)

public static String findTopkWords(String string, int k) {
    if (string == null || string.length() == 0) {
        return null;
    }

    String[] stringArray = string.split(" ");
    Map<String, Integer> map = new HashMap<String, Integer>();
    List<String> list = new ArrayList<String>();

    for (int i = 0; i < stringArray.length; i++) {
        if (map.containsKey(stringArray[i])) {
            map.put(stringArray[i], map.get(stringArray[i]) + 1);
        } else {
            map.put(stringArray[i], 1);
            list.add(stringArray[i]);
        }
    }
    if (k > map.size()) {
        return null;
    }

    int[] ary = new int[list.size()];
    for (int i = 0; i < ary.length; i++) {
        ary[i] = map.get(list.get(i));
    }
    Arrays.sort(ary);
    int num = ary[ary.length - k];

    for (int i = 0; i < list.size(); i++) {
        if (map.get(list.get(i)) == num) {
            return list.get(i);
        }
    }
    return null;
}




// Test

public static void main(String[] args) {
    String aString = "abc eqre abc earg abc a a a a a c c c b b b b b b b b b b b dafe c";
    System.out.println(findTopkWords(aString, 8));
}

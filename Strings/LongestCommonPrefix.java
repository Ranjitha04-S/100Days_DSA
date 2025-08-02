import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Traverse characters of first string
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);

            // Compare with all other strings
            for (int j = 1; j < strs.length; j++) {
                // If index i is out of bounds or mismatch found
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i); // Return common prefix so far
                }
            }
        }

        return strs[0]; // All characters matched
    }

    public static String longestCommonPrefixBetter(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
            // Shorten prefix
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }

    return prefix;
}

   public static String longestCommonPrefixOptimal(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    Arrays.sort(strs); // Sort alphabetically

    String first = strs[0];
    String last = strs[strs.length - 1];
    int i = 0;

    while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
        i++;
    }

    return first.substring(0, i);
}

    public static void main(String[] args) {
        String[] input1 = {"flowers", "flow", "fly", "flight"};
        String[] input2 = {"dog", "cat", "animal", "monkey"};

        System.out.println("Input 1 → " + longestCommonPrefix(input1)); // Output: "fl"
        System.out.println("Input 2 → " + longestCommonPrefix(input2)); // Output: ""
    }
}



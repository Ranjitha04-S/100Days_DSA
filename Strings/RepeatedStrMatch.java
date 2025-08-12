public class RepeatedStrMatch {
    public static  int repeatedStringMatchBrute(String a, String b) {
        int count = 1;
        StringBuilder repeated = new StringBuilder(a);

        while (repeated.length() < b.length()) {
            repeated.append(a);
            count++;
        }

        if (repeated.indexOf(b) != -1) {
            return count;
        }

        repeated.append(a);
        if (repeated.indexOf(b) != -1) {
            return count + 1;
        }

        return -1;
    }

public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder repeated = new StringBuilder(a);

        // Repeat until length >= b's length
        while (repeated.length() < b.length()) {
            repeated.append(a);
            count++;
        }

        // Check with current repetition
        if (kmpSearch(repeated.toString(), b)) {
            return count;
        }

        // Check with one more repetition
        repeated.append(a);
        if (kmpSearch(repeated.toString(), b)) {
            return count + 1;
        }

        return -1;
    }

    // KMP Search method
    private boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // Build LPS array
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdabcdab";
        int result = repeatedStringMatchBrute(s1, s2);
        System.out.println(result);
    }
}

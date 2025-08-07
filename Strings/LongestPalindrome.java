public class LongestPalindrome {
    //TC = O(n^3)
    //SC = O(1)
    public static String longestPalindromeBrute(String s) {
    int n = s.length();
    String longest = "";

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            String sub = s.substring(i, j + 1);
            if (isPalindrome(sub) && sub.length() > longest.length()) {
                longest = sub;
            }
        }
    }
    return longest;
}

private static boolean isPalindrome(String str) {
    int l = 0, r = str.length() - 1;
    while (l < r) {
        if (str.charAt(l++) != str.charAt(r--)) return false;
    }
    return true;
}

    //TC = O(n^2)
    //SC = O(1)
    public static String longestPalindrome(String s) {
    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++) {
        int len1 = expandFromCenter(s, i, i);     // Odd length
        int len2 = expandFromCenter(s, i, i + 1); // Even length
        int len = Math.max(len1, len2);

        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }

    return s.substring(start, end + 1);
}

private static int expandFromCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;
}

public static void main(String[] args) {
    String str = "aabcb";
    String result = longestPalindrome(str);
    System.out.println("Result is "+ result);
}

}

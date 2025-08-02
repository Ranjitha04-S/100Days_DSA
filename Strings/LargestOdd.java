public class LargestOdd {
    public class LargestOddSubstring {

    public static void main(String[] args) {
        String input1 = "5347";
        String input2 = "0214638";
        String input3 = "0002468";
        String input4 = "35427";

        System.out.println("Input: " + input1 + " → Output: " + bruteForce(input1));
        System.out.println("Input: " + input2 + " → Output: " + bruteForce(input2));
        System.out.println("Input: " + input3 + " → Output: " + bruteForce(input3));
        System.out.println("Input: " + input4 + " → Output: " + bruteForce(input4));
    }

    public static String bruteForce(String s) {
        String maxOdd = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);

                // Skip substrings with leading zero (except single-digit "0")
                if (sub.charAt(0) == '0' && sub.length() > 1)
                    continue;

                // Check if last digit is odd
                char last = sub.charAt(sub.length() - 1);
                if ((last - '0') % 2 == 1) {
                    // Compare based on length first, then lexicographically
                    if (maxOdd.equals("") ||
                        sub.length() > maxOdd.length() ||
                        (sub.length() == maxOdd.length() && sub.compareTo(maxOdd) > 0)) {
                        maxOdd = sub;
                    }
                }
            }
        }

        return maxOdd;
    }

     public static String largestOddNumber(String s) {
        // Traverse from end to find the last odd digit
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if ((ch - '0') % 2 == 1) {
                String result = s.substring(0, i + 1);

                // Remove leading zeros (if any)
                int j = 0;
                while (j < result.length() && result.charAt(j) == '0') {
                    j++;
                }

                return j < result.length() ? result.substring(j) : "";
            }
        }

        return ""; // No odd digit found
    }
}

}

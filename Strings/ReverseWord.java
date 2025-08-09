public class ReverseWord {
    public static String reverseWordsBrute(String s) {
        String[] words = s.split(" "); // split by spaces
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) { // skip empty strings caused by multiple spaces
                sb.append(words[i]).append(" ");
            }
        }

        return sb.toString().trim(); // remove last space
    }

    public static String reverseWordsBetter(String s) {
        s = s.trim();
        String[] words = s.split("\\s+"); // split by one or more spaces

        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    public static String reverseWordsOptimal(String s) {
        // Step 1: Remove extra spaces
        char[] chars = trimSpaces(s).toCharArray();

        // Step 2: Reverse entire char array
        reverse(chars, 0, chars.length - 1);

        // Step 3: Reverse each word
        reverseEachWord(chars);

        return new String(chars);
    }

    private static String trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') left++;
        // remove trailing spaces
        while (right >= left && s.charAt(right) == ' ') right--;

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') { // keep only one space
                sb.append(c);
            }
            left++;
        }
        return sb.toString();
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private static void reverseEachWord(char[] chars) {
        int n = chars.length;
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && chars[end] != ' ') end++;
            reverse(chars, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsBrute("the sky is blue"));       // blue is sky the
      
}
}


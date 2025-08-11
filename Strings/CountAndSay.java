import java.util.HashMap;

public class CountAndSay {
    
    // Brute force: always regenerate from start for each n
    public static String countAndSayBrute(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = buildNext(result); // Build new from scratch
        }
        return result;
    }

    private static String buildNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    //Better
    static HashMap<Integer, String> memo = new HashMap<>();

    public static String countAndSayBetter(int n) {
        if (n == 1) return "1";
        if (memo.containsKey(n)) return memo.get(n);
        
        String prev = countAndSayBetter(n - 1); // recursion
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(prev.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(prev.charAt(prev.length() - 1));
        
        memo.put(n, sb.toString());
        return sb.toString();
    }

    //Optimal
    public static String countAndSay(int n) {
        if (n == 1) return "1"; // base case
        
        String result = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            // Append last group
            sb.append(count).append(result.charAt(result.length() - 1));
            
            result = sb.toString();
        }
        
        return result;
    }


    
    public static void main(String[] args) {
        System.out.println(countAndSay(1)); // 1
        System.out.println(countAndSay(4)); // 1211
        System.out.println(countAndSay(5)); // 111221
    }
}

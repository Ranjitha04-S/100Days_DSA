import java.util.Stack;

public class MinAddParentheses {
     static boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false; // More ')' than '(' at some point
        }
        return balance == 0;
    }
    
    // Brute force
    static int minAddBruteForce(String s) {
        int moves = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while (!isValid(sb.toString())) {
            for (int i = 0; i <= sb.length(); i++) {
                // Try inserting '('
                String test1 = sb.substring(0, i) + "(" + sb.substring(i);
                if (isValid(test1)) {
                    sb.insert(i, "(");
                    moves++;
                    break;
                }
                // Try inserting ')'
                String test2 = sb.substring(0, i) + ")" + sb.substring(i);
                if (isValid(test2)) {
                    sb.insert(i, ")");
                    moves++;
                    break;
                }
            }
        }
        return moves;
    }

    static int minAddStack(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    insertions++; // Need one '('
                }
            }
        }
        // Remaining '(' need closing
        return insertions + stack.size();
    }

     static int minAddOptimal(String s) {
        int openNeeded = 0;  // For extra ')'
        int closeNeeded = 0; // For extra '('
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                closeNeeded++;
            } else { // ')'
                if (closeNeeded > 0) {
                    closeNeeded--; // match with previous '('
                } else {
                    openNeeded++; // Need an extra '('
                }
            }
        }
        return openNeeded + closeNeeded;
    }

    public static void main(String[] args) {
        System.out.println(minAddBruteForce("())")); // 1
        System.out.println(minAddBruteForce("(((")); // 3
    }
}
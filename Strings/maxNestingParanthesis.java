public class maxNestingParanthesis {
    public static int maxDepth(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int depth = 0;

            if (s.charAt(i) == '(') {
                // For every '(', count how deep the nesting goes from this point
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        depth++;
                    } else if (s.charAt(j) == ')') {
                        depth--;
                    }

                    // When matching ')' is found, stop checking
                    if (depth == 0) {
                        break;
                    }

                    // Update max depth encountered so far
                    max = Math.max(max, depth);
                }
            }
        }

        return max;
    }

    //Optimal solution

    public int maxDepthOptimal(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        String str = "(1+(2*3)+((8)/4))+1";
        int result = maxDepth(str);
        System.out.println(result);
    }
}



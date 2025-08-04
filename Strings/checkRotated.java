public class checkRotated {
// We loop i from 0 to n - 1 → O(n)
// Inside the loop:
// s.substring(i) takes O(n - i)
// s.substring(0, i) takes O(i)
// String concatenation + takes O(n) (because new string is created)
// rotated.equals(goal) takes O(n)
// So for each iteration:
// Total time per loop: O(n)
// Number of iterations: n
    private static boolean isRotatedCheckBrute(String s, String goal){
       if(s.length() != goal.length()) return false;
       int n = s.length();

       for (int i = 0; i < n; i++) {
           String rotated = s.substring(i) + s.substring(0, i);
           if(rotated.equals(goal)) return true;
        }
        return false;
    }

    //Using String Builder //infuture also know abt queue method
/* Loop runs n times:
Each iteration does:
charAt(0) → O(1)
deleteCharAt(0) → O(n) (shifts characters left)
append(char) → O(1)
sb.toString() → O(n) (copies characters to a new string)
equals(goal) → O(n) (character-by-character comparison)
So per iteration:
O(n) + O(n) = O(2n) → O(n)
And the loop runs n times →
Total time = O(n²) */
    private static boolean isRotatedCheckBetter(String s, String goal){
       if(s.length() != goal.length()) return false;
       int n = s.length();
       StringBuilder sb = new StringBuilder();

       for(int i = 0; i < n; i++){
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);

            if(sb.toString().equals(goal)) return true;
        }
        return false;
    }

    // Optimal Solution (Concatenation Trick)
    private static boolean isRotatedCheckOptimal(String s, String goal){
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String str1 = "Ranjitha";
        String str2 = "jithaRan";
        
        boolean result = isRotatedCheckOptimal(str1, str2);
        System.err.println(result);
    }
}

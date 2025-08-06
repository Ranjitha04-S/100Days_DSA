public class stringToInteger {
    
    //Brute 
    //TC = O(n^2)
    //SC = O(k) k <= n
    public static  int myAtoi(String s) {
    s = s.trim(); // remove whitespaces
    if (s.length() == 0) return 0;

    boolean isNegative = false;
    int i = 0;
    if (s.charAt(0) == '-') {
        isNegative = true;
        i++;
    } else if (s.charAt(0) == '+') {
        i++;
    }

    String numStr = "";
    while (i < s.length() && Character.isDigit(s.charAt(i))) {
        numStr += s.charAt(i);
        i++;
    }

    if (numStr.length() == 0) return 0;

    try {
        int num = Integer.parseInt(numStr);
        return isNegative ? -num : num;
    } catch (Exception e) {
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
}

    //Integer.MAX_VALUE = 2147483647 (2³¹ - 1)
    //Integer.MIN_VALUE = -2147483648 (-2³¹)
    //TC = O(n), SC =O(1)
    public static int myAtoiOptimal(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;
        
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
            
            if (sign * res <= INT_MIN) {
                return INT_MIN;
            }
            if (sign * res >= INT_MAX) {
                return INT_MAX;
            }
            
            i++;
        }

        return (int)(res * sign);        
    }

    public static void main(String[] args) {
        String str = "   -2365abc";
        int result = myAtoiOptimal(str);
        System.out.println(result);
    }
}

package Arrays;
import java.util.Stack;

public class paranthesis {
   
    /*brute force
    Time Complexity: O(n²)
    Because contains() and replace() run in O(n)
    Loop can run up to O(n) times
    
    Space Complexity: O(n)
New strings are created during each replace() (String is immutable)
    */
    public static boolean isValid(String n){
        while(n.contains("()") || n.contains("{}")||n.contains("[]") ){
            n = n.replace("{}", "") 
            .replace("()", "") 
            .replace("[]", "");
        }
     return n.isEmpty();

    }

    public static boolean isValidBetter(String n){
       Stack<Character> stack = new Stack<>();

       for(char ch : n.toCharArray()){
        if(ch == '{' || ch == '(' || ch == '['){
            stack.push(ch);
        }
        else{
            if(stack.isEmpty()) return false;
            char top = stack.pop();
            if((ch == '}' && top != '{') || 
               (ch == ')' && top != '(') ||
               (ch == ']' && top != '[')){
                return false;
               }
                  
        }
       }
       return stack.isEmpty();
    }

    public static void main(String[] args) {
        String check = "}(}{})";
        System.out.println(isValidBetter(check));
    }
}

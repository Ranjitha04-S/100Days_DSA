
import java.util.Stack;

public class ReverseString {
    
    //TC = O(n)
    //SC = O(n)
    private static String reverseStringBrute(String s){
      s += " ";
      Stack<String> store = new Stack<>();
      String str = "";

      for(int i = 0; i < s.length(); i++)
      {
        if(s.charAt(i) == ' '){
          store.push(str);
          str = "";
        }
        else{
            str += s.charAt(i);
        }
      }

      String ans = "";
      while(store.size() > 1)
      {
        ans += store.peek() + " ";
        store.pop();
      }
      ans += store.peek();
      return ans;
    }


    // Tc = O(n)
    //SC = O(1)
    private static String reverseStringOptimal(String s){
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        while(left <= right)
        {
            char ch = s.charAt(left);
            if(ch != ' '){
                temp += ch;
            }
            else if(ch == ' '){
                if(!ans.equals(""))
                {
                    ans = temp + " " + ans;
                }
                else{
                    ans = temp;
                }
                temp = "";
            }
            left ++;
        }
        if(!temp.equals("")){
            if(!ans.equals("")){
                ans = temp + " " + ans;
            }
            else{
                ans = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "Hello world";
        System.out.println("Original String is: " + input);
        System.out.println("Reversed String is: " + reverseStringBrute(input));
    }
}


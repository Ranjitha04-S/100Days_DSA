public class removeOuterParan {

    //TC = O(n)
    //SC = O(n)
    //Using Substring
    private static String RemoveBrute(String str)
    {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int balance = 0;

        for(int i = 0; i < str.length(); i++)
        {
          char ch = str.charAt(i);

          if(ch == '(') balance++;
          else balance--;

          if(balance == 0)
          {
            result.append(str.substring(start+1 , i));
            start = 1 + i;
          }
        }
        return result.toString();
    }

    //TC= O(N)
    //SC =O(N)
    //without using Substring

     private static String RemoveOptimal(String str)
    {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for(char ch : str.toCharArray())
        {
            if(ch == '('){
                if(depth > 0){
                    result.append(ch);
                }
                depth++;
            }
            else
            {
                depth --;
                if(depth > 0)
                {
                    result.append(ch);
                }
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(RemoveOptimal(s));
    }
}

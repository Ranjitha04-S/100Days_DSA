import java.util.*;
public class romanToInteger {
    
    //These maps are small and their size never depends on the input s.
    //Even if s is 1 character or 15 characters long, the maps are always the same size.
    //TC = O(n), SC= O(1)
    public int romanToIntBrute(String s) {
        Map<String, Integer> special = new HashMap<>();
        special.put("IV", 4);
        special.put("IX", 9);
        special.put("XL", 40);
        special.put("XC", 90);
        special.put("CD", 400);
        special.put("CM", 900);
        
        Map<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int result = 0;
        int i = 0;

        while(i < s.length()){
            if(i+1 < s.length()){
                String pair = s.substring(i, i+2);
                if(special.containsKey(pair)){
                    result += special.get(pair);
                    i += 2;
                    continue;
                } 
            }
             result += value.get(s.charAt(i));
            i++;
        }
        return result;
   }

   /*for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i += 1;
            }
        }

        return res;
    } */

   //Optimal solution using single hashmap
   //TC = O(n), SC = O(1)
  private static int romanToIntOptimal(String s){
    Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length()-1; i++) {
            if(roman.get(s.charAt(i)) < roman.get(s.charAt(i+1)))
            {
                result -= roman.get(s.charAt(i));
            }
            else{
                result += roman.get(s.charAt(i));
            }
        }
        return result + roman.get(s.charAt(s.length()-1));
  }

  public static void main(String[] args) {
      String str = "XCMXCIV";
      int result = romanToIntOptimal(str);
      System.out.println(result);
  }
}

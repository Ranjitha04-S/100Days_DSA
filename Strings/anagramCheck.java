import java.util.Arrays;

public class anagramCheck {

    //Using array sorting
    //tc = O(n log n)
    //sc = O(n)
    public static boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;

        char arr1[] = s.toCharArray(); // O(n)
        char arr2[] = t.toCharArray();

        Arrays.sort(arr1); //O(n log n)
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);//O(n)

    }

    //Using array sorting
    //tc = O(n log n)
    //sc = O(n)
    private static String sortingStrings(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    private static boolean isAnagramTUF(String s, String t){
       if(s.length() != t.length()) return false;

       sortingStrings(s);
       sortingStrings(t);

       for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i) != t.charAt(i)) return false;
       }
       return true;
    }

    //Optimal solution using character freq
    //TC =
    //SC =
    private static boolean isAnagramOptimal(String s, String t){
       if(s.length() != t.length()) return false;
       
       int[] count = new int[256];

       for (int i = 0; i < s.length(); i++) {
           count[s.charAt(i)]++;
           count[t.charAt(i)]--;
       }
       for(int ch : count){
        if(ch != 0) return false;
       }
       return true;
    }
    

    public static void main(String[] args) {
        String s1 = "Ranji";
        String s2 = "Ranji";

        boolean result = isAnagramTUF(s1, s2);
        System.out.println(result);
    }
}


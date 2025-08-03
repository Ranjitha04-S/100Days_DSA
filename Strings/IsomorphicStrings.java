import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // Check if sc is already mapped
            if (sToT.containsKey(sc)) {
                if (sToT.get(sc) != tc) return false;
            } else {
                sToT.put(sc, tc);
            }

            // Check if tc is already mapped
            if (tToS.containsKey(tc)) {
                if (tToS.get(tc) != sc) return false;
            } else {
                tToS.put(tc, sc);
            }
        }

        return true;
    }

    // Test the method
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));     // true
        System.out.println(isIsomorphic("foo", "bar"));     // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("ab", "aa"));       // false
    }
}



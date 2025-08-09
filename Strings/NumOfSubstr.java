public class NumOfSubstr {
  public static int countAllSubstrings(String s) {
        int n = s.length();
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(countAllSubstrings("abcd")); // 10
    }
}
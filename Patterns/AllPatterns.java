package Patterns;

public class AllPatterns {
    private static void patternA(int n){
        
    }
    

    public static void main(String[] args) {
        int nTestCases[] = {3,5,10};
        for(int i : nTestCases){
            System.out.println("Test case n = " + i);
            patternA(i);
            System.out.println("----------------------------------------------------");
        }
    }
}

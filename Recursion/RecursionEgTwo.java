package Recursion;
public class RecursionEgTwo {
    static void func(int i, int n){
        if(i > n) return;
        System.out.println("Hello");
        func(i+1, n);
    }
    public static void main(String[] args) {
        int n = 5;
        func(1, n);
    }
}

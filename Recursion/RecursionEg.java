package Recursion;

public class RecursionEg {
    static int count = 0;
    static void func(){
        if(count == 7) return;
        System.out.println(count);
        count++;
        func();
    }
    public static void main(String[] args) {
        func();
    }
}

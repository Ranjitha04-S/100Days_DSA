package Recursion;

public class RecursionEg3 {
    static void func(int i, int n){
        if(i > n) return;
        System.out.println(i);
        func(i+1, n);
    }

    //n to 1
    static void func1(int i, int n){
        if(i < 1) return;
        System.out.println(i);
        func1(i-1, n);
    }
    
    //Sum of first n numbers
    static void sumfun(int n, int sum){
       if(n < 1) 
       {
        System.out.println(sum);
        return;

       }
       sumfun(n-1, sum+n);
       
    }

    //Sum of first n numbers using functional way
        static int sumfun1(int n){
            if(n == 0) return 0;

            return n + sumfun1(n-1);
        }


    public static void main(String[] args) {
        int n = 5;
        //func1(n, n);
        sumfun1(n);
    }
}

package Arrays;
import java.util.*;


public class largestElement {
    /*Using sorting 
    Time = O(n log n) 
    space = O(1)*/
    public static int largestElementBrute(int arr[]){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
 
    /*Using Recursion and max var 
    Time = O(n) 
    space = O(1)*/
    public static int largestElementRecursion(int arr[]){
       int max = arr[0];
       for(int i = 0; i < arr.length; i++){
        if(arr[i] > max) {
            max = arr[i];
        }
       }
       return max;
    }

    public static void main(String[] args) {
        int arr[] = {2 , 2 , 3 , 0};
       int large = largestElementRecursion(arr);
       System.out.println("The largest element in Array is: " + large);
    }
}
 
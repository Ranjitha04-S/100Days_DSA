package Arrays;

import java.util.Arrays;

public class secondLargest {
    /*Time Complexity: O(NlogN), 
    For sorting the array
    Space Complexity: O(1) */
    private static void secondLargestSmallestBrute(int arr[], int n){
        if(n == 0 || n == 1){
            System.out.println(-1);
            System.out.println(" ");
            System.out.println(-1);
            System.out.println(" ");

        }
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[n-2];
        System.out.println("The second smallest element: " + small);
        System.out.println("The second largest element: " + large);
    }
    

    /*Better solution using traverse the array
      TC = O(n);
      SC = O(1)
     */



     private static void secondLargestSmallestBetter(int arr[], int n){
        if(n == 0 || n == 1){
            System.out.println(-1);
            System.out.println(" ");
            System.out.println(-1);
            System.out.println(" ");
        }
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }
        for(int i = 0; i < n; i++){
            if(arr[i] < secondSmall && arr[i] != small){
                secondSmall = arr[i];
            }
            if(arr[i] > secondLarge && arr[i] != large){
                secondLarge = arr[i];
            }
        }
        System.out.println("Second Smallest Element is : " + secondSmall);
        System.out.println("Second Largest Element is : " + secondLarge);
    }

    //Best Optimal Solutions

    //secondLargest 

    private static int secondLargestOptimal(int arr[], int n){
        if(n < 2) return -1;
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(arr[i] > large){
                secondLarge = large;
                large = arr[i];
            }
            else if(arr[i] > secondLarge && arr[i] != large){
                secondLarge = arr[i];
            }
        }
       return (secondLarge == Integer.MIN_VALUE) ? -1 : secondLarge;
    }
    //second smallest

    private static int secondSmallestOptimal(int arr[], int n){
        if(n < 2) return -1;
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(arr[i] < small){
                secondSmall = small;
                small = arr[i];
            }
            else if(arr[i] < secondSmall && arr[i] != small){
                secondSmall = arr[i];
            }
        }
        return secondSmall;
    }


    
    public static void main(String[] args) {
        int[] arr = {1,5,8,9,3};
        int n = arr.length;
        int result1 = secondLargestOptimal(arr, n);
        int result2 = secondSmallestOptimal(arr, n);
        System.out.println("The second largest is: " + result1);
        System.out.println("The second Smallest is: " + result2);
    }
}

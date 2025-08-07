package Arrays;

import java.util.ArrayList;

public class moveZero {
    /* tc = O(2*N)
       Sc = O(N)
     */

    private static int[] moveZeroBrute(int arr[]){
       ArrayList<Integer> temp = new ArrayList<>();
       int n = arr.length;
       for(int i = 0; i < n; i++){
        if(arr[i] != 0)
           temp.add(arr[i]);
       }
       for(int i = 0; i < temp.size();i++){
        arr[i] = temp.get(i);
       }
       for(int i = temp.size(); i < n; i++){
        arr[i] = 0;
       }
       return arr;
    }


    /* TC = O(n)
       SC = O(1) 
     */
    private static int[] moveZeroOptimal(int arr[]){
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        if(j == -1) return arr;

        for (int i = j+1; i < arr.length; i++) {
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
    
    /*Leetcode */
    public void moveZeroes(int[] nums) {
        int j = -1;
        int n = nums.length;
        if (n == 0) return; 
        for(int i = 0; i < n; i++ ){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }

        if(j == -1){
            for(int i = 0; i < n; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = j+1; i < n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        for(int i = 0; i < n; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {1,0,2,3,0,4,0,1};
        int result[] = moveZeroOptimal(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        // System.out.println("");
    }


}

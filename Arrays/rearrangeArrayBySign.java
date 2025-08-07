package Arrays;

import java.util.ArrayList;

public class rearrangeArrayBySign {

    //Brute TC = O(n+n/2)
    // SC = O(n/2+n/2) = O(n)
    private static int[] RearrangeBrute(int nums[], int n){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(nums[i] > 0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }

        for(int i = 0; i < n/2; i++){
            nums[2*i] = pos.get(i);
            nums[2*i+1] = neg.get(i);
        }
        return nums;
    }
    public static void main(String[] args) {
        int arr[] = {-1,-3,1,3};
        int n = arr.length;
        int elements[] = RearrangeBrute(arr, n);
        for(int i = 0; i < n; i++){
            System.err.print(elements[i] + " ");
        }
    }
}

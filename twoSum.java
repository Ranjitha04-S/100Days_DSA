import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

//Brute force solution    
// time complexity = O(n^2)
// Space complexity = O(1)

    public static int[] twoSumBrute(int arr[] , int target){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
               if(arr[i] + arr[j] == target){
                 return new int[] {i, j};
               }
            }
        }
        return new int[] {-1,-1};
    }

//Better Solution
//Tc = O(n)
//Sc = O(n)

public static int[] twoSumBetter(int arr[] , int target){
    HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
            }
        for(int i = 0; i < arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i , map.get(complement)};
            }
        }
        return new int[]{};
    }

//Optimal Solution
//Tc = O(n)
//Sc = O(n)
public static int[] twoSumOptimal(int arr[] , int target){
    HashMap<Integer, Integer> map = new HashMap<>();
    
        for(int i = 0; i < arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement) , i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int target = 9;
       int[] result = twoSumBetter(arr, target);
       System.out.println(Arrays.toString(result)); 
    }
}

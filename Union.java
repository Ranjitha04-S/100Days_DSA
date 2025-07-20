
import java.util.ArrayList;
import java.util.HashMap;

public class Union {

    private static ArrayList<Integer> unionArray(int arr1[] , int arr2[], int n1, int n2){
       HashMap<Integer,Integer> map = new HashMap<>();
       ArrayList<Integer> union = new ArrayList<>();
       for(int i = 0; i < n1; i++){
          map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
       }
       for(int i = 0; i < n2; i++){
          map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
       }
       for(int store : map.keySet()){
        union.add(store);
       }
       return union;
    }
    public static void main(String[] args) {
        int nums1[] = {1,3,4,7,8};
        int nums2[] = {1,2,5,6,8};
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> result = unionArray(nums1, nums2, n1, n2);
        System.err.println("The Union of Two Arrays are: ");
       
            System.err.println(result + " ");
        
    }
}

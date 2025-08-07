package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Union {
   
   //TC = O(n+m)
   //SC =  O(n+m)
   //Using Hashmap
   private static ArrayList<Integer> unionArrayOne(int arr1[], int arr2[], int n, int m)
   {
      HashMap <Integer, Integer> freq = new HashMap<>();
      ArrayList<Integer> union = new ArrayList<>();

      for(int i = 0; i < n; i++){
         freq.put(arr1[i], freq.getOrDefault(arr1[i],0)+1);
      }
      for(int i = 0; i < m; i++){
         freq.put(arr2[i], freq.getOrDefault(arr2[i],0)+1);
      }

      for(int it : freq.keySet()){
         union.add(it);
      }
      return union;
   }

   //Using Hashset
   //TC = O(m+n)
   //SC = O(m+n)

   private static ArrayList<Integer> unionArrayTwo(int arr1[], int arr2[], int n, int m){
      HashSet<Integer> total = new HashSet<>();
      ArrayList<Integer> union = new ArrayList<>();

      for(int i = 0; i < n; i++){
         total.add(arr1[i]);
      }
      for(int i = 0; i < m; i++){
         total.add(arr2[i]);
      }
      for(int it : total){
         union.add(it);
      }
      return union;
   }

   //Using Two pointers
   //TC = O(m+n)
   //SC = O(m+n)
   private static ArrayList<Integer> unionArrayThree(int arr1[], int arr2[], int n, int m)
   {
      ArrayList<Integer> union = new ArrayList<>();
      int i = 0, j = 0;
      
      while(i < n && j < m){
         if(arr1[i] <= arr2[j]){
            if(union.size() == 0 || union.get(union.size()-1) != arr1[i]){
               union.add(arr1[i]);
            }
            i++;
         }
            else{
            if( union.size() == 0 || union.get(union.size()-1) != arr2[j]){
               union.add(arr2[j]);
            }
            j++;
            }
         }
         
         while(i < n)
         {
            if (union.get(union.size()-1) != arr1[i]){
               union.add(arr1[i]);
            }
            i++;
         }
         while(j < m)
         {
            if (union.get(union.size()-1) != arr2[j]){
               union.add(arr2[j]);
            }
            j++;
         }
         
      return union;
   
   }
    public static void main(String[] args) {
        int nums1[] = {1,3,4,7,8};
        int nums2[] = {1,2,5,6,8};
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> result = unionArrayThree(nums1, nums2, n1, n2);
        System.err.println("The Union of Two Arrays are: ");
       
            System.err.println(result + " ");
        
    }
   }

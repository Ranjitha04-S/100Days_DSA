public class isSorted {
    /*TC = O(n^2) 
      SC = O(1)
      two traversal
    */
    private static boolean  isArraySortedBrute(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[i]) return false;
            }
        }
        return true;
    }
    /*check Array rotated and sorted */
    
    public static boolean check(int[] arr){
        int check = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > arr[(i+1%arr.length)]){
                check++;
            }
            if(check > 1) return false;
        }
         return true;
    }

    /*Single traversal ==> optimal
     Time Complexity: O(N)
     Space Complexity: O(1)
     */
     private static boolean  isArraySortedOptimal(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i -1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,6,6};
        boolean result = isArraySortedOptimal(arr);
        System.out.println(result);
    }
}

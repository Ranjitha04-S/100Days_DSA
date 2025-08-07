package Arrays;
public class findSingleNumber {
    /*TC= O(N^2)
      SC = O(1)
     */
    private static int findSingleNumberBrute(int arr[]){
        for(int i =0; i < arr.length; i++){
            // int number = arr[i];
            int count = 0;
        
        for(int j = 0; j < arr.length; j++){
            if(arr[j] == arr[i]){
                count++;
            } 
        }
        if(count == 1) return arr[i];
    }
    
    return -1;    
    }
    
    /*Using Hash array
     * TC = O(n)
     * SC = O(max)
     */
    private static int findSingleNumberBetter1(int arr[]){
        int n = arr.length;
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] hash = new int[max + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        
        for (int i = 0; i < n; i++) {
            if(hash[arr[i]] == 1){
                return arr[i];
            }
        }
        return -1;

    }
    

    
    public static void main(String[] args) {
        int nums[] = {1,2,1,2,4,5,6,6};
        int result = findSingleNumberBetter1(nums);
        System.out.println("The Single element is: " + result);
    }
}

public class leftRotate {

    /*tc = O(n) 
      sc = O(n)
    */
    private static void leftRotate(int arr[]){
        int n = arr.length;
        int temp[] = new int[n];
        for(int i = 1; i < n; i++){
           temp[i-1] = arr[i];
        }
        temp[n-1] = arr[0];
        for(int i = 0; i < n; i++){
            System.out.print(temp[i] + " ");
        }
    }

    /*tc = O(n)
     Sc = O(1)
     */

    private static void leftRotateOptimal(int arr[]){
        int n = arr.length;
        int temp = arr[0];
        for(int i = 0; i < n-1; i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = temp;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
     public static void main(String[] args) {
        int nums[] = {1,2,3,5,6};
        leftRotateOptimal(nums);
        leftRotate(nums);
    
}
}

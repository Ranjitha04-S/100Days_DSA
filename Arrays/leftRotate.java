package Arrays;
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
    private static void rightRotate(int arr[]){
        int n = arr.length;
        int temp[] = new int[n];
        for(int i = 1; i < n; i++){
            temp[i] = arr[i-1];
        }
        temp[0] = arr[n-1];
        for(int i = 0; i < n; i++){
            System.err.print(temp[i] + " ");
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

    private static void rightRotateOptimal(int arr[]){
        int n = arr.length;
        int temp = arr[n-1];
        for (int i = n-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
         for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

    }
     public static void main(String[] args) {
        int nums[] = {1,2,3,5,6};
        // leftRotateOptimal(nums);
        // leftRotate(nums);
        // rightRotate(nums);
        rightRotateOptimal(nums);
}
}

public class leftRotateDplaces {
  //TC = O(N) SC =O(N)
  private static void RotateToRight(int arr[], int n, int k){
     if(n == 0) return;
     int temp[] = new int[k];
     for(int i = n-k; i < n; i++){
      temp[i-n+k] = arr[i];
     }
     for(int i = n-k-1; i >= 0; i--){
      arr[i+k] = arr[i];
     }
     for(int i=0; i < k; i++){
      arr[i] = temp[i];
     }
  }

  private static void RotateToLeft(int arr[], int n, int k){
     if(n == 0) return;
     int temp[] = new int[k];
     for(int i = 0; i < k; i++){
      temp[i] = arr[i];
     }
     for(int i = 0; i < n-k; i++){
      arr[i] = arr[i+k];
     }
     int j = 0;
     for(int i=n-k; i < n; i++){
      arr[i] = temp[i-n+k];
     }
  }

  //Optimal Reversal approach 
  //TC = O(n) SC = O(1)
  private static void Reverse(int arr[], int start, int end){
    while(start < end){
      int temp = arr[start];
      arr[start] =arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
  private static void RotateToRightOptimal(int arr[], int n, int k){
    k = k%n;
    Reverse(arr, 0 , n-k-1);
    Reverse(arr, n-k, n-1);
    Reverse(arr, 0, n-1);

  }

  private static void RotateToLeftOptimal(int arr[], int n, int k){
    k = k%n;
    Reverse(arr, 0, k-1);
    Reverse(arr, k, n-1);
    Reverse(arr,0 , n-1);
  }
  public static void main(String args[]) {
    int[] arr = {1,2,3,4,5,6,7};
    int n = 7;
    int k = 9;
    RotateToLeftOptimal(arr, n, k);
    System.out.print("After Rotating the k elements to left ");
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }
}
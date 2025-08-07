package Arrays;
public class linearSearch {

    private static int searchArray(int arr[], int num){
        for (int i = 0; i < arr.length; i++) {
            
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {2,6,4,6,7,8};
        int check = 6;
        int result =searchArray(nums,check);
        System.err.println(result);
    }
}

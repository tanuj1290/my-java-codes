public class firstAndLastIndexBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,3,4,5,5,5,5,6,7,7,7,8,9};
        findFirstAndLastPosition(arr, 8);

    }
    public static void findFirstAndLastPosition(int[] arr, int target){
        int left = 0, right = arr.length-1;
        int first = -1;
        // finding the first position
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>target){
                right = mid-1;
            } 
            else if (arr[mid]<target) {
                left = mid+1;
            } 
            else{
                first = mid;
                right = mid - 1;
            }
        }
        left = 0; 
        right = arr.length-1;
        int last = -1;

        // finding the last position
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>target){
                right = mid-1;
            } 
            else if (arr[mid]<target) {
                left = mid+1;
            } 
            else{
                last = mid;
                left = mid + 1;
            }
        }

        System.out.println(first+"  "+last);
    }
}

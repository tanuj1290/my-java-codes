// Given a sorted rotated array of unique elements and a target.
// Find the index of target in the array.
// If target is not present in the array, return -1.
// Sample input
// arr = {9, 11, 14, 15, 20, 22, 25, 1, 3, 5, 7}
// target = 14
// Sample Output
// 2

public class searchInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,2,3};
        int target = 3;
        int minIndex = findMin(arr); // finds the index of minimum value
        int ans = binarySearch(arr, 0, minIndex-1, target); // in this case it finds the first sorted array
        if(ans == -1){
            ans = binarySearch(arr, minIndex, arr.length-1, target); // in this case it finds the last sorted array
        }
        System.out.println(ans);
    }
    public static int binarySearch(int[] arr, int left, int right, int target){
        while (left<=right) {
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int findMin(int[] arr){
        int left = 0, right = arr.length-1;
        while (left<right) {
            int mid = (left+right)/2;
            if (arr[mid]<arr[right]) {
                right = mid;
            }else{
                left = mid+1;          }
            
        }
        return left;
    }
}

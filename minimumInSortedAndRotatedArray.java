// Given a sorted rotated array of unique elements. Find the minimum element in the array.
// Sample input
// arr = {7, 8, 10, 15, 16, 2, 4, 6}
// Sample Output
// 2

// Brute Fore Approach
public class minimumInSortedAndRotatedArray {
    public static void main(String[] args) {
        // int[] arr = {4,5,6,7,8,1,2,3};
        int[] arr = {1,2,3,4,5,6,7,8};
        int minIndex = findMin(arr);
        System.out.println(arr[minIndex]);
    }
    public static int findMin(int[] arr){
        int left = 0, right = arr.length-1;
        while (left<right) {
            int mid = (left+right)/2;
            if (arr[mid]<arr[right]) {
                right = mid;
            }else{
                left = mid+1;
            }
            
        }
        return left;
    }
}

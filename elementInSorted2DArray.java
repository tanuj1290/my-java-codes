// Given a row-wise and column-wise sorted matrix and a target.
// Check if target is present in the matrix.
// Sample input
// matrix = {1, 4, 6, 8, 10
//           2, 7, 9, 12, 15
//           3, 11, 20, 22, 24
//           5, 16, 25, 30, 40}
// target = 11
// Sample Output
// true

public class elementInSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = { { 1, 4, 6, 8, 10 }, { 2, 7, 9, 12, 15 }, { 3, 11, 20, 22, 24 }, { 5, 16, 25, 30, 40 } };
        int target = 55;
        System.out.println(findTarget(arr, target));
    }
    public static boolean findTarget(int[][] arr, int target){
        int i = 0, j = arr.length-1;
        while (i<arr.length && j>=0) {
            if(arr[i][j] == target){
                return true;
            }else if(arr[i][j] < target){
                i++;
            }else{
                j--;
            }     
        }

        return false;
    }
}

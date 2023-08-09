public class maxSubArray {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int curSum = 0, maxSum = Integer.MIN_VALUE;
        // System.out.println(maxSum);
        for(int i = 0; i<A.length; i++){
            curSum += A[i];
            if(curSum>maxSum){
                maxSum = curSum;
            }
            if(curSum<0){
                curSum = 0;
            }
        }
        System.out.println("Max Sum Sub Array: "+maxSum);
    }
}

// Print sum of first n natural numbers

public class recursion_2e {
    public static void rec(int i, int n, int sum) {
        if(i==n){
            sum+=i;
            System.out.println(sum);
            return;
        }
        sum+=i;
        rec(i+1,n,sum);
        // System.out.println(i);
        /*
        int i = 1;
        if(n==0)
            return 0;
        return n + rec(n-1); 
         */
    }
    public static void main(String[] args) {
        int n = 5;
        rec(1,n,0);
    }
}

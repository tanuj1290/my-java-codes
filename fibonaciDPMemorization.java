// Memorization or Top Down
public class fibonaciDPMemorization {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n, new int[n+1]));
    }
    public static int fib(int n, int[] fb){
        if(n==0 || n == 1)
            return n;
        if(fb[n]!=0)
            return fb[n];
        int fib = fib(n-1, fb) + fib(n-2, fb);
        fb[n] = fib;
        return fb[n];
    }
}

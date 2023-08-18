// Bottom up approch or tabulation or iterative

public class fibonaciDPTabulation {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));    
        
    }

    public static int fib(int n){
        int[] fb = new int[n+1]; // n+1 size is required to have the nth number at nth position
        fb[0] = 0;
        fb[1] = 1 ;
        for (int i = 2; i < fb.length; i++) {
            fb[i] = fb[i-1] + fb[i-2];
        }
        return fb[n];
    }

}

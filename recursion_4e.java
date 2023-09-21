// Print the fibonacci sequence till nth term*
public class recursion_4e {
    // print till nth term
    /*
    public static void fib(int a, int b, int n){
        // a is second last term
        // b is last term
        int c = a+b;
        if(c>=n)
            return;
        System.out.print(" "+ c+" ");
        a = b;
        b = c;
        fib(a,b, n); 
    }
     */

    // print n terms    
    public static void fib(int a, int b, int n){
        // a is second last term
        // b is last term
        int c = a+b;
        if(n==0)
            return;
        System.out.print(" "+ c+" ");
        a = b;
        b = c;
        fib(a,b, n-1); 
    }
    public static void main(String[] args) {
        int n = 10, a = 0, b = 1;
        System.out.print(a+ " "+ b);
        fib(a,b, n-2);
    }
}

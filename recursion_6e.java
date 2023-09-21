// Print x^n (stack height = logn)
public class recursion_6e {
    public static int power(int x, int n){
        if(n==0)
            return 1;
        if(x==0)
            return 0;
        if(n%2==0)
            return power(x, n/2)* power(x, n/2);
        else    
            return power(x, n/2)* power(x, n/2) * x;

    }
    public static void main(String[] args) {
        int x = 2, n = 4;
        System.out.println(power(x, n));
    }
}

// Print x^n (stack height = n)

public class recursion_5e {
    public static int power(int x, int n){
        if(n==0)
            return 1;
        if(x==0)
            return 0;
        return x* power(x, n-1);
        

    }
    public static void main(String[] args) {
        int x = 2, n = 2;
        System.out.println(power(x, n));
    }
}

public class recursion_3e {
    public static int fact(int n){
        if(n==0 || n==1)
            return 1;
        return n*fact(n-1);
    }
    // public static void fact(int n, int product){
    //     if(n==0){
    //         System.out.println(product);
    //         return;
    //     }
    //     product*=n;
    //     fact(n-1, product);
    // }
    public static void main(String[] args) {
        int n = 5;
        // fact(n, 1);
        System.out.println(fact(n));
    }
}

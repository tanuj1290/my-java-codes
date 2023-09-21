// Print Numbers from 5 to 1
public class recursion_1e {
    public static void printNum(int n){
        if(n==0)
            return;

        System.out.println(n);
        printNum(n-1);
    }
    public static void main(String[] args) {
        printNum(5);
    }
}
// import java.util.ArrayList;

public class XOREquualsXOR {
    public static int mul(int a,int b, int mod){
        int ans=0;
        a%=mod;
        while(b>0){
            if(b%2==1){
                ans=(ans+a)%mod;
            }
            
            a = (a * 2) % mod;
 
            
            b /= 2;
        }
        return ans%mod;
    }
    public static void main(String[] args) {
        int A = 2;
        int count = 0;

        // long val=1<<A;
        int ans;
        if (A == 0)
            System.out.println(1);
        ans = 3;
        // System.out.print(mul(3,3,35));
        // int k=1;
        for (int i = 1; i < A; i++) {
            ans = mul(ans, 3, 1000000007);

        }
        // ans = (Math.pow(3,A) % (1000000007));
        // ans=ans ;/
        // // ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        // for (int i = 0; i < Math.pow(2, A); i++) {
        // for (int j = 0; j < Math.pow(2, A); j++) {
        // if((i^j) == (i|j)){
        // // ArrayList<Integer> temp = new ArrayList<>();
        // // temp.add(i);
        // // temp.add(j);
        // // list.add(temp);
        // count++;
        // }
        // }
        // }
        // int size = list.size();
        System.out.println(ans);
    }
}

import java.util.ArrayList;

public class productOfAll {
    public static void main(String[] args) {
        int mod = 1000000007;
        ArrayList<Integer> A = new ArrayList<>();
        A.add(9);
        A.add(9);
        A.add(9);
        A.add(9);
        int n = A.size();
        long pre[] = new long[n];
        long suf[] = new long[n];
        pre[0] = 1;
        for(int i = 1; i < n; ++i){
            pre[i] = (pre[i-1]*A.get(i-1))%mod;
        }
        suf[n-1] = 1;
        for(int i = n-2; i >= 0; --i){
            suf[i] = (suf[i+1]*A.get(i+1))%mod;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i){
            int x = Math.toIntExact((pre[i]*suf[i])%mod);
            ans.add(x);
        }
        System.out.println(ans);
    }
}

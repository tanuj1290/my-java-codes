public class AmountNumToWords {
     public static  String numTostr(int n, String s){
        String[] ones = {"","one-","two-","three-","four-","five-","six-","seven-","eight-","nine-","ten-","eleven-","twelve-","thirteen-","fourteen-","fifteen-","sixteen-","seventeen-","eighteen-","nineteen-"};
        String[] tones = {"","","twenty-","thirty-","forty-","fifty-","sixty-","seventy-","eighty-","ninety-"};
        String res ="";
        if(n>19){
            res+= tones[n/10] + ones[n%10];
        }
        else{
            res+=ones[n];
        }
        if(n!=0){
            res+=s;
        }
        return res;
    }
    public int solve(String A, String B) {
        int n = Integer.parseInt(A);
        String res = "";
        res+=numTostr((n/10000000),"crore-");
        res+=numTostr((n/100000)%100,"lakh-");
        res+=numTostr((n/1000)%100,"thousand-");
        res+=numTostr((n/100)%10,"hundred-");
        if(n>100 && n%100!=0){
            res+="and-";
        }
        res+=numTostr((n%100),"");
        //System.out.println(res);
        String match = res.substring(0,res.length()-1);
        //System.out.println(match);
        if(B.equals(match)){
            return 1;
        }
        else{
            return 0;
        }
        
    }
}

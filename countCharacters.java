public class countCharacters {
    public static void main(String[] args) {
        String a="aabbbbeeeeffggg";
        char prev = a.charAt(0) ;
        int count = 1;
        String res = "";
        for(int i =1; i<a.length();i++){
            char c = a.charAt(i);
            if (prev==c) {
                count++;
                prev = c;
            }else{
                res =  res+String.valueOf(prev)+String.valueOf(count);
                prev = c;
                count=1;
            }
        }
        res =  res+String.valueOf(prev)+String.valueOf(count);
        System.out.println(res);
    }
}

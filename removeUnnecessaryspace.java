import java.util.Arrays;

/**
 * removeUnnecessaryspace
 */
public class removeUnnecessaryspace {
    public static void main(String[] args) {
        String s = "ram is      good boy      ";
        System.out.println(remove(s));

    }
    public static String remove(String s){
        String res = "";
        String[] ar = s.trim().split(" ");
        
        System.out.println(Arrays.toString(ar));
        for (int i = 0; i<ar.length;i++) {
            res += ar[i].trim();
            if(i != ar.length-1 && ar[i] != ""){
                res+= " ";
            }
        }
        return res;
    }
}
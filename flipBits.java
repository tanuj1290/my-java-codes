import java.util.BitSet;

public class flipBits {
    public static void main(String[] args) {
        int n = 7;
        String a = Integer.toBinaryString(n);
        System.out.println(a);
        String output = "";
        for (int i = 0; i < a.length(); i++) {
            char cc = a.charAt(i);
            if(cc == '1'){
                output  = output + "0";
            }else{
                output  = output + "1";
            }
        }
        int aa = Integer.parseInt(output, 2);
    }
}

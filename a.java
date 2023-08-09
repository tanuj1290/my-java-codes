import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

class a {
    public static void main(String[] args) {
        // str;
        String A = "aabbccd";
        int B = 2;
        // String[] str = a.split(" ");
        A+='!';
        int count = 0;
        String res = "";
        int i = 0, j = 0;
        while (j < A.length()) {
            if (A.charAt(i) == A.charAt(j)) {
                count++;
                j++;
            } else {
                if (count != B) {
                    res = res + A.substring(i, j);
                }
                i = j;
                count = 0;
            }
        }
        System.out.println(res);
    }

}
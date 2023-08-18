import java.util.Arrays;

public class longestCommonPrefix {
    public static void main(String[] args) {
        // String[] strs = { "fbower", "faow", "flight" };
        String[] strs = { "aaa", "aa", "aaa" };
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int index = 0;
        while (index < s1.length() && index < s2.length()) {
            if(s1.charAt(index) == s2.charAt(index))
                index++;
            else
                break;
        }
        System.out.println(s1.substring(0, index));
    }
}

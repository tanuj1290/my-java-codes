// You are given a string A, and you have to find all the amazing substrings of A.
// An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmaingSubarrays {

    public static boolean isVowel(char c){
        Character[] v = {'a', 'e',  'i',  'o',  'u',  'A',  'E',  'I',  'O',  'U'};
        Set<Character> vowels = new HashSet<>(Arrays.asList(v));
        if(vowels.contains(c))
            return true;
        else
            return false;

    }
    public static void main(String[] args) {
        String A = "ABEC";
        int mod = 10003;
        int index = 0;
        int len = A.length();
        int res = 0;
        for (char l : A.toCharArray()) {
            String sub = "";
            if(isVowel(l)){
                sub = A.substring(index, len);
                res = (res + sub.length()) % mod;
                System.out.println(sub);
            }

            index++;
        }
        System.out.println(res);
        System.out.println(isVowel('a'));
    }
}

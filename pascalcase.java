import java.util.regex.Pattern;

public class pascalcase {
    public static void main(String[] args) {
        String s = "OneTwoThree";
        System.out.println(pascal(s));
        
    }
    public static int pascal(String s){
        if(Pattern.matches("[a-z]", String.valueOf(s.charAt(0)))){
            System.out.println("first letter is small");
            return 0;
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            if(Pattern.matches("[A-Z]", String.valueOf(c))){
                count++;
            }
            if(c == ' '){
                return 0;
            }
        }
        return count;
    }
}

import java.util.HashMap;
import java.util.Map;

public class countUnique {
    public static void main(String[] args) {
        String s = "alphaadida";
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        // System.out.println(charCountMap.);    
        int uniqueCharacterCount = 0;
        for (char c : charCountMap.keySet()) {
            if (charCountMap.get(c) == 1) {
                uniqueCharacterCount++;
            }
        }
        System.out.println(uniqueCharacterCount);
        // System.out.println(charCountMap);
    }
}

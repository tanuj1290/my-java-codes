import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CharacterFrequency {
    public static void main(String[] args) {
        String A = "interviewbit";
        Map<Character,Integer> map = new LinkedHashMap<>();
        
        for (Character c : A.toCharArray()) {
            // System.out.println(map.get(c));
            map.put(c, map.getOrDefault(c, 0)+1);
            // System.out.println(map);
        }
        System.out.println(map);
        List<Integer> arr = new ArrayList<>();
        arr.addAll(map.values());
        System.out.println(arr);
        // for (int i = 0; i < map.size(); i++) {
        //     System.out.println(map.values());
        // }
    }
}

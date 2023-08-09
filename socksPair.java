import java.util.ArrayList;
import java.util.HashMap;

/**
 * socksPair
 */
public class socksPair {

    public static void main(String[] args) {
        ArrayList<Integer> pairs =new ArrayList<Integer>();
        pairs.add(1);
        pairs.add(2);
        pairs.add(2);
        pairs.add(1);
        pairs.add(3);
        pairs.add(4);

        HashMap<Integer, Integer> socks = new HashMap<>();
        for (Integer integer : pairs) {
            socks.put(integer, socks.getOrDefault(integer, 0)+1);
        }
        final int[] total = {0};
        socks.forEach((k,v) -> {
            int num = v/2;
            // System.out.println(num);
            total[0] += num;

            
        });
        System.out.println(total[0]);
        // System.out.println(pairs);
        // System.out.println(socks);

    }
}
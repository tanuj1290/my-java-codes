import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AmountWordsToNum {
    public static void main(String[] args) {
        String A = "18";
        String B = "thirty-only";
        int value = 0;
        int finalValue = 0;
        Map<String, Integer> nums = new HashMap<>();
        Map<String, Integer> numsO = new HashMap<>();
        nums.put("one", 1);
        nums.put("two", 2);
        nums.put("three", 3);
        nums.put("four", 4);
        nums.put("five", 5);
        nums.put("six", 6);
        nums.put("seven", 7);
        nums.put("eight", 8);
        nums.put("nine", 9);
        nums.put("ten", 10);

        nums.put("eleven", 11);
        nums.put("twelve", 12);
        nums.put("thirteen", 13);
        nums.put("fourteen", 14);
        nums.put("fifteen", 15);
        nums.put("sixteen", 16);
        nums.put("seventeen", 17);
        nums.put("eighteen", 18);
        nums.put("nineteen", 19);

        nums.put("twenty", 20);
        nums.put("thirty", 30);
        nums.put("fourty", 40);
        nums.put("fifty", 50);
        nums.put("sixty", 60);
        nums.put("seventy", 70);
        nums.put("eighty", 80);
        nums.put("ninety", 90);

        numsO.put("hundred", 100);
        numsO.put("thousand", 1000);

        if (B.charAt(0) == '-' || B.charAt(B.length() - 1) == '-') {
            System.out.println('0');
        } else {
            B = B.replace('-', ' ');
            B = B.replace(" and ", " ");
            String split[] = B.toLowerCase().split(" ");
            for (String string : split) {
                if (nums.containsKey(string) || numsO.containsKey(string)) {
                    if (nums.containsKey(string)) {
                        value += nums.get(string);
                    } else if (numsO.containsKey(string)) {
                        value *= numsO.get(string);
                        finalValue += value;
                        value = 0;
                    }
                    // System.out.println(string);
                }
            }
            finalValue += value;
            if (finalValue == Integer.parseInt(A)) {
                System.out.println('1');
            } else {
                System.out.println('0');
            }
            System.out.println(finalValue);
            System.out.println(Arrays.toString(split));
            System.out.println(B);

        }

    }
}

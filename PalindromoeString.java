public class PalindromoeString {
    public static void main(String[] args) {
        String a = "asa assdf";
        String[] str = a.split(" ");

        int count = 0;
        for (String s : str) {
            System.out.println(s + " " + s.length());
            // Collections.reverse(string);
            String temp = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                temp = temp + s.charAt(i);
            }
            System.out.println("temp is: " + temp + " " + temp.length());
            System.out.println("s is: " + s + " " + s.length());
            System.out.println(s.equals(temp));

            if (s == temp) {
                count++;
                System.out.println(count);
            }
            System.out.println(count);
        }
        System.out.println(count);
    }
}

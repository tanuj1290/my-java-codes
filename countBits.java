public class countBits {
    public static void main(String[] args) {
        long a = 11;
    
        String bits = Long.toBinaryString(a);
        int count = 0;
        for(int i  = 0; i < bits.length(); i++){
            char c = bits.charAt(i);
            if(c == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
}

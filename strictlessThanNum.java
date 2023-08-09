public class strictlessThanNum {
    public static void main(String[] args) {
        int arr[] ={1,4,6,2,9,0};
        int n = 7;
        int num = 1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            
        }

        for (int i : arr) {
            if(i<num){
                count++;
            }
        }
        System.out.println(count);
    }
}

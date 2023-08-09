import java.util.ArrayList;

public class maxMin {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1); 
        A.add(2); 
        A.add(-2);
        System.out.println(A);
        int min = A.get(0);
        int max = A.get(0);
        for (Integer i : A) {
            if(i>max)
                max = i;
            if(i<min)
                min = i;
        }
        // Set<Integer> set = new HashSet<>();
        // for (Integer integer : A) {
        //     set.add(integer);
        // } 
        System.out.println(max);
        System.out.println(min);

    }
}

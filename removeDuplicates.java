import java.util.LinkedHashSet;

public class removeDuplicates {
    public static void main(String[] args) {
        int A[] = {4, 2, 1, 2, 3, 1, 2};
        LinkedHashSet<Integer> distincHashSet = new LinkedHashSet<>();
        for (Integer integer : A) {
            distincHashSet.add(integer);
        
        }
        System.out.println(distincHashSet);
        int[] a = new int[distincHashSet.size()];
        int j = 0;
        for (int i : distincHashSet) {
            a[j] = i;
            j++;

        }
        // Integer[] a = distincHashSet.toArray(new Integer[0]);
        for (int i : a) {
        System.out.println(i);            
        }
    }
}

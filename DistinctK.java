// Problem Statement
// Ashish is provided with a collection of n strings in which some strings are of repeating nature but he has been given with a number k. His task is to find the kth unique string. Also before finding the kth unique string he has to sort each individual string beforehand. If there are fewer unique strings than k return empty string. As his best friend, your task is to help Ashish in accomplishing the task.

// Input Format
// The first line contains an integer n denoting the number of strings.
// The next n lines contain strings.
// The next line contains an integer k.

// Output Format
// The output contains the kth distinct string.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        int i = 0;
        while (n-->0) {
            str[i] = sc.next();
            i++;
        }
        Set<String> dsit = new HashSet<>();

        for (int j = 0; j < str.length; j++) {
            dsit.add(str[j]);
            // System.out.print(str[j]+" ");

        }
        

        sc.close();
        // System.out.println(dsit.size());
        // for (String string : dsit) {
        //     System.out.println(string);
        // }
        // System.out.println();
    }
}

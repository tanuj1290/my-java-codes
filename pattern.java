public class pattern {
    public static void main(String[] args) {
        int n = 7;
        int totalRows = 2*n - 1;
        int numCols = 2 * n - 1;
        
        // Loop to print the pattern
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < n; j++) {
              if (i % 2 == 0) {
                if (j == 0 || j == n - 1) {
                  System.out.print("x");
                } else {
                  System.out.print("-");
                }
              } else {
                if (i <= n - 1 && j == i) {
                  System.out.print("x");
                } else if (i > n - 1 && j == n - i - 1) {
                  System.out.print("x");
                } else {
                  System.out.print("-");
                }
              }
            }
            System.out.println();
          }

    }
}

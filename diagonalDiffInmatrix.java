public class diagonalDiffInmatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},
                        {4,5,6},
                        {9,8,9}};
        int diag1 = 0;
        int diag2 = 0;
        for (int i=0 ;i<arr.length;i++){
            for (int j=0 ;j<arr.length;j++){
                if(i == j){
                    diag1+=arr[i][j];
                    System.out.println("Adding "+ arr[i][j]);
                }
            }
        }
        int row = 0;
        int column = arr[0].length-1;
        int a = 0;
        while (a<arr.length) {
            System.out.println("Row: "+row+" Column "+ column);
            diag2+=arr[row][column];
            row++;
            column--;
            a++;
        }

       
        System.out.println(diag1);
        System.out.println(diag2);
        System.out.println(Math.abs(diag1-diag2));
    }
}

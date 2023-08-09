import java.util.Scanner;

public class soildere {

    public static void swapPositions(int[] soldiers, int row, int col) {
        int m = (col - row) / 2;
        for (int i = 0; i <= m; i++) {
            int temp = soldiers[row + i];
            soldiers[row + i] = soldiers[col - i];
            soldiers[col - i] = temp;
        }
    }

    public static int findSoldierIdAfterActions(int N, int Q, int[][] actions, int posSoldier) {
        int[] soldiers = new int[N];
        for (int i = 0; i < N; i++) {
            soldiers[i] = i + 1;
        }

        for (int i = 0; i < Q; i++) {
            int row = actions[i][0] - 1;
            int col = actions[i][1] - 1;
            swapPositions(soldiers, row, col);
        }

        return soldiers[posSoldier - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        int[][] actions = new int[Q][2];

        for (int i = 0; i < Q; i++) {
            actions[i][0] = scanner.nextInt();
            actions[i][1] = scanner.nextInt();
        }

        int posSoldier = scanner.nextInt();

        int result = findSoldierIdAfterActions(N, Q, actions, posSoldier);
        System.out.println(result);

        scanner.close();
    }
}

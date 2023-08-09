public class MinimumProjects {
    public static int minProjectsToZeroError(int N, int[] errorScores, int P, int Q) {
        int totalProjects = 0;

        while (anyGreaterThanZero(errorScores)) {
            int minError = getMinError(errorScores);

            for (int i = 0; i < N; i++) {
                if (errorScores[i] > 0) {
                    errorScores[i] -= minError;
                }
            }

            totalProjects++;

            for (int i = 0; i < N; i++) {
                if (errorScores[i] > 0) {
                    errorScores[i] -= Q;
                }
            }
        }

        return totalProjects;
    }

    public static boolean anyGreaterThanZero(int[] array) {
        for (int value : array) {
            if (value > 0) {
                return true;
            }
        }
        return false;
    }

    public static int getMinError(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            if (value > 0 && value < min) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] errorScores = {10, 15, 7, 12, 9};
        int P = 2;
        int Q = 3;

        int result = minProjectsToZeroError(N, errorScores, P, Q);
        System.out.println(result); // This will output the minimum number of projects required
    }
}
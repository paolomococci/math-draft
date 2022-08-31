package local.example.outcome.algorithm;

public class Knapsack {

    public static int recursive(
            int[] weights,
            int[] values,
            int multiplicity,
            int weightLimit
    ) {
        if (multiplicity <= 0) {
            return 0;
        } else if (weights[multiplicity-1] > weightLimit) {
            return recursive(weights, values, (multiplicity-1), weightLimit);
        } else {
            return Math.max(
                    recursive(weights, values, (multiplicity-1), weightLimit),
                    recursive(weights, values, (multiplicity-1), (weightLimit-weights[multiplicity-1]))
                            + values[multiplicity-1]
            );
        }
    }

    public static int dynamic(
            int[] weights,
            int[] values,
            int multiplicity,
            int weightLimit
    ) {
        if (multiplicity <= 0 || weightLimit <= 0)
            return 0;

        int[][] matrix = new int[multiplicity+1][weightLimit+1];

        for (int i = 0; i <= weightLimit; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 1; i <= multiplicity; i++) {
            for (int j = 1; j <= weightLimit; j++) {
                if (weights[i-1] > j) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.max(
                            matrix[i-1][j],
                            matrix[i-1][j-weights[i-1]] + values[i-1]
                    );
                }
            }
        }
        return matrix[multiplicity][weightLimit];
    }
}

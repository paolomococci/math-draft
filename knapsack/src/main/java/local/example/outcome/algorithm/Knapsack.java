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
        // TODO
        return 0;
    }
}

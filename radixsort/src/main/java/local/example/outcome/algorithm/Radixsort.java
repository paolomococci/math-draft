package local.example.outcome.algorithm;

public class Radixsort {

    public static void radixsort(int[] messy) {

        int maxInt = findMaxIntFromArray(messy);
        int numberOfDigits = computeNumberOfDigits(maxInt);
        int placeholder = 1;

        while (numberOfDigits-- > 0) {
            sortOn(messy, placeholder);
            placeholder *= 10;
        }
    }

    private static void sortOn(int[] messy, int placeholder) {
        // TODO
    }

    private static int computeNumberOfDigits(int maxInt) {
        // TODO
        return 0;
    }

    private static int findMaxIntFromArray(int[] messy) {
        // TODO
        return 0;
    }
}

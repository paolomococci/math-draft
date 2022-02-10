package local.example.outcome.algorithm;

public class Quicksort {

    public static void quickSort(long keys[], int begin, int ending) {

    }

    private static long partition(long keys[], int begin, int ending) {

        long pivot = keys[ending];
        int index = begin-1;

        for (int i = 0; i < ending; i++) {
            if (keys[i] <= pivot) {
                index++;
                long swap = keys[index];
                keys[index] = keys[i];
                keys[i] = swap;
            }
        }

        return 0L;
    }
}

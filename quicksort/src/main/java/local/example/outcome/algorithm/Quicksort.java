package local.example.outcome.algorithm;

public class Quicksort {

    public static void quickSort(long keys[], int begin, int ending) {

    }

    private static int partition(long keys[], int begin, int ending) {

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

        long swap = keys[index+1];
        keys[index+1] = keys[ending];
        keys[ending] = swap;

        return index+1;
    }
}

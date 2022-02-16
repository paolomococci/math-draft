package local.example.outcome.algorithm;

import local.example.outcome.model.Assortment;
import local.example.outcome.model.Item;

public class Quicksort {

    public static Item[] quickSort(Assortment assortment) {
        return quicksort(assortment.toArray(), 0, assortment.toArray().length-1);
    }

    private static Item[] quicksort(Item[] items, int begin, int ending) {
        if (begin < ending) {
            int partitioningIndex = partition(items, begin, ending);
            quicksort(items, begin, partitioningIndex-1);
            quicksort(items, partitioningIndex+1, ending);
        }
        return items;
    }

    private static int partition(Item[] keys, int begin, int ending) {

        int pivot = keys[ending].key;
        int index = begin-1;

        for (int i = begin; i < ending; i++) {
            if (keys[i].key <= pivot) {
                index++;
                Item swap = keys[index];
                keys[index] = keys[i];
                keys[i] = swap;
            }
        }

        Item swap = keys[index+1];
        keys[index+1] = keys[ending];
        keys[ending] = swap;

        return index+1;
    }

    public static void quickSort(long[] keys, int begin, int ending) {
        if (begin < ending) {
            int partitioningIndex = partition(keys, begin, ending);
            quickSort(keys, begin, partitioningIndex-1);
            quickSort(keys,partitioningIndex+1, ending);
        }
    }

    private static int partition(long[] keys, int begin, int ending) {

        long pivot = keys[ending];
        int index = begin-1;

        for (int i = begin; i < ending; i++) {
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

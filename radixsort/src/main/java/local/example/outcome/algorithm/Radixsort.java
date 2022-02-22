package local.example.outcome.algorithm;

import local.example.outcome.model.Assortment;
import local.example.outcome.model.Item;

import java.util.stream.IntStream;

public class Radixsort {

    private static final int RADIX = 10;

    public static Item[] radixSort(Assortment assortment) {
        // TODO
        return new Item[0];
    }

    public static void radixsort(int[] messy) {

        int maxKey = findMaxIntFromArray(messy);

        for (int position = 1; (maxKey/position) > 0; position *= RADIX) {
            sortOn(messy, position);
        }
    }

    private static void sortOn(int[] messy, int position) {
        int[] frequency = new int[RADIX];
        int[] tidy = new int[messy.length];

        for (int j : messy) {
            int digit = (j / position) % RADIX;
            frequency[digit]++;
        }

        IntStream.range(1, RADIX).forEach(i -> frequency[i] += frequency[i - 1]);

        for (int i = (messy.length-1); i >= 0; i--) {
            int digit = (messy[i]/position)%RADIX;
            tidy[frequency[digit]-1] = messy[i];
            frequency[digit]--;
        }

        System.arraycopy(tidy, 0, messy, 0, messy.length);
    }

    private static int findMaxIntFromArray(int[] messy) {
        int max = messy[0];
        for (int i = 1; i < messy.length; i++)
            if (messy[i] > max)
                max = messy[i];
        return max;
    }
}

package local.example.outcome.algorithm;

import local.example.outcome.model.Item;

import java.util.stream.IntStream;

public class Radixsort {

    private static final int RADIX = 10;

    public static Item[] radixSort(Item[] items) {

        int maxKey = findMaxValueOfKeyArray(items);

        for (int position = 1; (maxKey/position) > 0; position *= RADIX) {
            sortOn(items, position);
        }
        return items;
    }

    private static void sortOn(Item[] items, int position) {
        int[] frequency = new int[RADIX];
        Item[] tidy = new Item[items.length];


        for (Item j : items) {
            int digit = (j.key / position) % RADIX;
            frequency[digit]++;
        }

        IntStream.range(1, RADIX).forEach(i -> frequency[i] += frequency[i - 1]);

        for (int i = (items.length-1); i >= 0; i--) {
            int digit = (items[i].key/position) % RADIX;
            tidy[frequency[digit]-1] = items[i];
            frequency[digit]--;
        }

        System.arraycopy(tidy, 0, items, 0, items.length);
    }

    protected static int findMaxValueOfKeyArray(Item[] items) {

        int[] keys = new int[items.length];

        for (int i = 0; i < keys.length; i++) keys[i] = items[i].key;

        int max = keys[0];
        for (int i = 1; i < keys.length; i++)
            if (keys[i] > max)
                max = keys[i];
        return max;
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

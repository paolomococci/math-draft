package local.example.outcome.algorithm;

public class Radixsort {

    public static void radixsort(int[] messy) {

        int maxKey = findMaxIntFromArray(messy);

        for (int position = 1; (maxKey/position) > 0; position *= 10) {
            sortOn(messy, position);
        }
    }

    private static void sortOn(int[] messy, int position) {
        int radix = 10;
        int[] frequency = new int[radix];
        int[] tidy = new int[messy.length];

        for (int i = 0; i < messy.length; i++) {
            int digit = (messy[i]/position)%radix;
            frequency[digit]++;
        }

        for (int i = 1; i < radix; i++) {
            frequency[i] += frequency[i-1];
        }

        for (int i = (messy.length-1); i >= 0; i--) {
            int digit = (messy[i]/position)%radix;
            tidy[frequency[digit]-1] = messy[i];
            frequency[digit]--;
        }

        System.arraycopy(tidy, 0, messy, 0, messy.length);
    }

    private static int findMaxIntFromArray(int[] messy) {
        int max = messy[0];
        for (int i = 1; i < messy.length; i++) {
            if (messy[i] > max) {
                max = messy[i];
            }
        }
        return max;
    }
}

package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class QuicksortTests {

    @Test
    public void rawTest() {
        long[] messy = {9, 7, 1, 0, 8, 2, 3, 4, 5, 6, 6};
        long[] tidy = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
        Quicksort.quickSort(messy, 0, messy.length-1);
        Assertions.assertArrayEquals(tidy, messy);
    }
}

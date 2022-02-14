package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class QuicksortTests {

    @Test
    public void rawTest() {
        // TODO
        long[] messy = {};
        long[] tidy = {};
        Quicksort.quickSort(messy, 0, messy.length-1);
        Assertions.assertArrayEquals(tidy, messy);
    }
}

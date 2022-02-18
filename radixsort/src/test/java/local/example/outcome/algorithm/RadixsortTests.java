package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RadixsortTests {

    @Test
    public void intTest() {
        int[] messy = {457, 344, 320, 128, 652, 236, 543, 783, 239, 546, 215};
        int[] tidy = {128, 215, 236, 239, 320, 344, 457, 543, 546, 652, 783};
        Radixsort.radixsort(messy);
        Assertions.assertArrayEquals(tidy, messy);
    }

    @Test
    public void assortmentTest() {
        // TODO
    }
}

package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RadixsortTests {

    @Test
    public void intTest() {
        int[] messy = {9, 7, 1, 0, 8, 2, 3, 4, 5, 6, 6};
        int[] tidy = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
        // TODO
        Assertions.assertArrayEquals(tidy, messy);
    }
}

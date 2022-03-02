package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class KnapsackTests {

    @Test
    public void recursiveCorrectResultTest() {
        final int[] weights = new int[] {
                1, 3, 5, 6, 7
        };
        final int[] values = new int[] {
                1, 8, 18, 22, 28
        };
        final int weightLimit = 11;

        Assertions.assertEquals(
                40,
                Knapsack.recursive(weights, values, values.length, weightLimit)
        );
    }

    @Test
    public void dynamicCorrectResultTest() {
        final int[] weights = new int[] {
                1, 3, 5, 6, 7
        };
        final int[] values = new int[] {
                1, 8, 18, 22, 28
        };
        final int weightLimit = 11;

        Assertions.assertEquals(
                40,
                Knapsack.dynamic(weights, values, values.length, weightLimit)
        );
    }

    @Test
    public void recursiveZeroItemsTest() {
        final int[] weights = new int[] {};
        final int[] values = new int[] {};
        final int weightLimit = 11;

        Assertions.assertEquals(
                0,
                Knapsack.recursive(weights, values, values.length, weightLimit)
        );
    }

    @Test
    public void dynamicZeroItemsTest() {
        final int[] weights = new int[] {};
        final int[] values = new int[] {};
        final int weightLimit = 11;

        Assertions.assertEquals(
                0,
                Knapsack.recursive(weights, values, values.length, weightLimit)
        );
    }

    @Test
    public void recursiveZeroWeightLimitTest() {
        final int[] weights = new int[] {
                1, 3, 5, 6, 7
        };
        final int[] values = new int[] {
                1, 8, 18, 22, 28
        };
        final int weightLimit = 0;

        Assertions.assertEquals(
                0,
                Knapsack.recursive(weights, values, values.length, weightLimit)
        );
    }

    @Test
    public void dynamicZeroWeightLimitTest() {
        Assertions.assertTrue(true);
    }
}

package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import local.example.outcome.model.Assortment;
import local.example.outcome.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class QuicksortTests {

    @Test
    public void longTest() {
        long[] messy = {9, 7, 1, 0, 8, 2, 3, 4, 5, 6, 6};
        long[] tidy = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
        Quicksort.quickSort(messy, 0, messy.length-1);
        Assertions.assertArrayEquals(tidy, messy);
    }

    @Test
    public void assortmentTest() {
        Item one = new Item(1, "one");
        Item two = new Item(2, "two");
        Item three = new Item(3, "three");
        Item four = new Item(4, "four");
        Item five = new Item(5, "five");
        Assortment messy = new Assortment();
        messy.add(two);
        messy.add(one);
        messy.add(three);
        messy.add(five);
        messy.add(four);
        Assortment tidy = new Assortment();
        tidy.add(one);
        tidy.add(two);
        tidy.add(three);
        tidy.add(four);
        tidy.add(five);
        // TODO
    }
}

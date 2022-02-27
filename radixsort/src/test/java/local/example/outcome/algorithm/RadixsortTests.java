package local.example.outcome.algorithm;

import io.quarkus.test.junit.QuarkusTest;

import local.example.outcome.model.Assortment;
import local.example.outcome.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RadixsortTests {

    @Test
    public void intTest() {
        int[] messy = {457, 344, 4, 320, 128, 652, 32, 236, 543, 98, 783, 239, 546, 215};
        int[] tidy = {4, 32, 98, 128, 215, 236, 239, 320, 344, 457, 543, 546, 652, 783};
        Radixsort.radixsort(messy);
        Assertions.assertArrayEquals(tidy, messy);
    }

    @Test
    public void findMaxValueOfKeyArrayTest() {
        Item _457 = new Item(457, "four hundred and fifty-seven");
        Item _344 = new Item(344, "three hundred and forty-four");
        Item _4 = new Item(4, "four");
        Item _320 = new Item(320, "three hundred and twenty");
        Item _128 = new Item(128, "one hundred twenty eight");
        Assortment messy = new Assortment();
        messy.add(_344);
        messy.add(_457);
        messy.add(_4);
        messy.add(_128);
        messy.add(_320);
        int max = Radixsort.findMaxValueOfKeyArray(messy.toArray());
        Assertions.assertEquals(457, max);
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
        Radixsort.radixSort(messy);
        int[] tidy = {1, 2, 3, 4, 5};
        int[] orderedArrayOfItemKeys = new int[messy.items.size()];
        for (int i = 0; i < messy.items.size(); i++) {
            orderedArrayOfItemKeys[i] = messy.items.get(i).key;
        }
        Assertions.assertArrayEquals(tidy, orderedArrayOfItemKeys);
    }
}

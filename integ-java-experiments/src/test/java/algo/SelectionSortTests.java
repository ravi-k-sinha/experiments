package algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SelectionSortTests {

    private SelectionSort ss;

    @Before
    public void setup() {
        ss = new SelectionSort();
    }

    @Test
    public void testSelectionSort_1() {
        sortIntsAndCheck(new int[] {4, 7, 1, 3, 2}, new int[] {1, 2, 3, 4, 7});
    }

    @Test
    public void testSelectionSort_2() {
        sortIntsAndCheck(new int[] {1, 2, 3, 4, 7}, new int[] {1, 2, 3, 4, 7});
    }

    @Test
    public void testSelectionSort_3() {
        sortIntsAndCheck(new int[] {1}, new int[] {1});
    }

    private void sortIntsAndCheck(int[] input, int[] expected) {
        Assert.assertArrayEquals(expected, ss.sortInts(input));
    }

}

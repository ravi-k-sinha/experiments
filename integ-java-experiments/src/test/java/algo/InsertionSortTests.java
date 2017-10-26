package algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTests {

    private InsertionSort is;

    @Before
    public void setup() {
        is = new InsertionSort();
    }

    @Test
    public void testInsertionSort_1() {
        int[] inputArray = new int[] {4, 7, 1, 3, 2};
        int[] expectedArray = new int[] {1, 2, 3, 4, 7};
        int[] result = is.sortInts(inputArray);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expectedArray, result);
    }

    @Test
    public void testInsertionSort_2() {
        int[] inputArray = new int[] {1, 2, 3, 4, 7};
        int[] expectedArray = new int[] {1, 2, 3, 4, 7};
        int[] result = is.sortInts(inputArray);

        System.out.println(Arrays.toString(result));

        Assert.assertArrayEquals(expectedArray, result);
    }

}

package algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTests {
    private QuickSort qs;

    @Before
    public void setup() {
        qs = new QuickSort();
    }

    @Test
    public void testQuickSort_1() {
        int[] input = new int[]{0, 5, 2, 1, 6, 3};
        int[] expected = new int[]{0, 1, 2, 3, 5, 6};
        int[] result = qs.sortInts(input);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort_2() {
        int[] input = new int[]{0, 1, 2, 3, 5, 6};
        int[] expected = new int[]{0, 1, 2, 3, 5, 6};
        int[] result = qs.sortInts(input);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort_3() {
            int[] input = new int[]{6, 5, 3, 2, 1, 0};
        int[] expected = new int[]{0, 1, 2, 3, 5, 6};
        int[] result = qs.sortInts(input);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort_4() {
        int[] input = new int[]{0, 0, 0, 0, 0, 0};
        int[] expected = new int[]{0, 0, 0, 0, 0, 0};
        int[] result = qs.sortInts(input);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort_5() {
        int[] input = new int[]{-1};
        int[] expected = new int[]{-1};
        int[] result = qs.sortInts(input);
        Assert.assertArrayEquals(expected, result);
    }

}

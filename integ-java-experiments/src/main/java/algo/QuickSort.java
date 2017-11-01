package algo;

public class QuickSort {

    public int[] sortInts(int[] input) {
        sort(input, 0, input.length - 1);
        return input;
    }

    private void sort(int[] array, int left, int right) {
        // if 0, 1 element, stop
        if (right - left <= 0) {
            return;
        }

        int pivot = partition(array, left, right);

        sort(array, left, pivot - 1);

        sort(array, pivot + 1, right);
    }

    // returns the pivot index after partition
    private int partition(int[] array, int left, int right) {

        System.out.printf("left=%d, right=%d\n", left, right);

        int pivotIndex = right;
        int pivot = array[pivotIndex];

        right -= 1;

        while(true) {

            while(left <= right && array[left] <= pivot) {
                left += 1;
            }

            while(right >=0 && array[right] > pivot) {
                right -= 1;
            }

            if (left >= right) {
                break;
            }
            else {
                swap(array, left, right);
            }
        }

        swap(array, left, pivotIndex);

        return left;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
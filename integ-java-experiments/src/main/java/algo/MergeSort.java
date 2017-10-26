package algo;

import java.util.Arrays;

public class MergeSort {

    public MergeSort() {}

    public int[] sortInts(int[] unsortedInts) {

        sort(unsortedInts, 0, unsortedInts.length - 1);

        return unsortedInts;
    }

    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        // Find sizes
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        System.arraycopy(arr, l + 0, L, 0, n1);

        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        // Merge the temp arrays

        int i = 0, j = 0; // initial indexes of arrays to be merged
        int k = l; // initial index of merged array

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }



    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        System.out.println(Arrays.toString(ms.sortInts(new int[]{9, 1, 3, 5, 99, 0, -1, 8})));
    }

}

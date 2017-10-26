package algo;

public class SelectionSort {

    public int[] sortInts(int[] unsortedInts) {

        for (int i = 0; i < unsortedInts.length; i++) {
            int low_index = i;

            for (int j = i + 1; j < unsortedInts.length; j++) {
                if (unsortedInts[j] < unsortedInts[low_index]) {
                    low_index = j;
                }
            }

            if (low_index != i) {
                int temp = unsortedInts[low_index];
                unsortedInts[low_index] = unsortedInts[i];
                unsortedInts[i] = temp;
            }
        }

        return unsortedInts;
    }

}

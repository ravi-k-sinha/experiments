package algo;

/**
 * Implements the classic insertion sort routine
 * Algo is as follows
 * <li>Start from the an index, and mark it as index with lowest value</li>
 * <li>Compare with elements to the left of it till we see smaller values or until we reach the end of the array</li>
 * <li>If another index has lower value, mark it as having lowest value</li>
 * <li>At the end of the iteration, swap the current lowest value index with index marked in the beginning</li>
 *
 * In essence we are inserting lowest value successively in increasing order indexes
 */
public class InsertionSort {

    public int[] sortInts(int[] unsortedArray) {

        int currentElem = -1;
        int position = -1;

        for (int i = 1; i < unsortedArray.length; i++) {
            currentElem = unsortedArray[i]; // Init with current index
            position = i; // Init with current index

            while(position > 0 && unsortedArray[position - 1] > currentElem) {
                unsortedArray[position] = unsortedArray[position - 1];
                position = position - 1;
            }

            unsortedArray[position] = currentElem;
        }

        return unsortedArray;
    }

}

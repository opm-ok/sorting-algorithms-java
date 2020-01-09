import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22}; // indexes: 6

        System.out.println(Arrays.toString(shellSort(intArray)));
        System.out.println(Arrays.toString(mergeSort(intArray, 0, intArray.length)));
    }



    // Merge Sort
    private static int[] mergeSort(int[] intArray, int start, int end){
        // start - beginning of array
        // end - length of array (end - 1 = last index of array)

        // e.g. no work required on an array of length 1
        // base case
        if (end - start < 2){
            return intArray;
        }

        int mid = (start + end) / 2;

        mergeSort(intArray, start, mid);
        mergeSort(intArray, mid, end);
        merge(intArray, start, mid, end);

        return intArray;
    }

    private static int[] merge(int[] intArray, int start, int mid, int end){

        // Do nothing if the int at the start of right array is larger than end of left array (no need to sort)
        if (intArray[mid - 1] <= intArray[mid]){
            return intArray;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];

        while (i < mid && j < end){
            tempArray[tempIndex++] = intArray[i] <= intArray[j] ?  intArray[i++] : intArray[j++];
        }

        // The right array has been merged to the intArray, however, the left array still has elements remaining
        if (j >= end && i < mid){
            for (int k = i; k < mid; k++) {
                tempArray[tempIndex++] = intArray[k];
            }
        }

        System.arraycopy(tempArray, 0, intArray, 0, tempArray.length);

        return intArray;
    }

    // Shell Sort
    private static int[] shellSort(int[] intArray){
        // Variation of Insertion sort
        // In-place algorithm
        // O(n2) worst case, but it can perform much better than that (depends on the gap)
        // Unstable algorithm

        for (int gap = intArray.length / 2; gap > 0; gap /= 2){

            for (int i = gap; i < intArray.length; i++){

                int selectedElement = intArray[i];
                int j = i;

                while (j >= gap && intArray[j - gap] > selectedElement){
                    intArray[j] = intArray[j - gap];
                    j-= gap;
                }
                intArray[j] = selectedElement;
            }
        }
        return intArray;
    }

    // Insertion Sort
    private static int[] insertionSort(int[] intArray){

        // In-place, stable algorithm, O(n2) quadratic time complexity
        // if array was sorted in decreasing order, every element needs to be swapped

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            int j = firstUnsortedIndex;


            while (j > 0 && intArray[j - 1] > intArray[j]){
                swap(intArray, j, j - 1);
                j--;
            }
        }
        return intArray;

    }

    // Selection Sort
    private static int[] selectionSort(int[] intArray){

        // In-place algorithm
        // O(n2) time complexity - quadratic
        // Unstable algorithm

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0 ; lastUnsortedIndex--) {

            int largestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++){
                if (intArray[i] > intArray[largestIndex]){
                    largestIndex = i;
                }
            }
            swap(intArray, lastUnsortedIndex, largestIndex);
        }

        return intArray;
    }

    // Bubble Sort
    private static int[] bubbleSort(int[] intArray){
        // unsortedPartitionIndex (last index of the unsorted array)
        // i = 0, index used to traverse the array from left to right

        // In-place algorithm (do not need to create another array to implement the algorithm. Saves memory
        // O(n2) time complexity - quadratic
        // Algorithm degrades quickly
        // Stable algorithm

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            for (int i = 0; i < lastUnsortedIndex; i++){
                if (intArray[i] > intArray[i + 1]){
                    swap(intArray, i, i +1);
                }
            }
        }

        return intArray;
    }

    // Swap 2 integers in an array
    private static void swap(int[] arr, int i, int j){

        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


// Stable vs unstable
    // Stable - maintains the relative ordering of two duplicate items
    // Unstable - does not maintain the relative ordering of two duplicate items

    // For example, if you have two '9's in an array, the algorithm is stable if the 9s do not change
    // positioning relative to each other.

    // Stable is preferable to an unstable sort (It can make a difference when sorting objects)



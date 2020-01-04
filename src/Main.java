import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22 }; // indexes: 6

        // Bubble Sort
        System.out.println(Arrays.toString(bubbleSort(intArray)));

        // Selection Sort
        System.out.println(Arrays.toString(selectionSort(intArray)));

        // Insertion Sort
        System.out.println(Arrays.toString(insertionSort(intArray)));

        // Insertion Sort
        System.out.println(Arrays.toString(shellSort(intArray)));

    }


    // Swap 2 integers in an array
    private static void swap(int[] arr, int i, int j){

        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
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

    // Insertion Sort
    private static int[] insertionSort(int[] intArray){

        // In-place algorithm
        // O(n2) time complexity - quadratic
        // Stable algorithm

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            int checkElement = intArray[firstUnsortedIndex];

            for (int sortedIndex = 0; sortedIndex <= firstUnsortedIndex ; sortedIndex++) {

                if (checkElement < intArray[sortedIndex]){
                    swap(intArray, checkElement, intArray[sortedIndex]);
                    break;
                }
            }
        }
        return intArray;
    }

    // Shell Sort
    private static int[] shellSort(int[] intArray){
        // Variation of Insertion sort
        // In-place algorithm
        // O(n2) worst case, but it can perform much better than that (depends on the gap)
        // Unstable algorithm

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < intArray.length ; i++) {
                int checkElement = intArray[i];

                int j = i;
                System.out.println(String.format("Value of j = %d and gap = %d", j, gap));

                while (j >= gap && intArray[j - gap] > checkElement){
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = checkElement;
            }
        }
        return intArray;
    }



} // end of Main


// Stable vs unstable

    // Stable - maintains the relative ordering of two duplicate items
    // Unstable - does not maintain the relative ordering of two duplicate items

    // For example, if you have two '9's in an array, the algorithm is stable if the 9s do not change
    // positioning relative to each other.

    // Stable is preferable to an unstable sort (It can make a difference when sorting objects)





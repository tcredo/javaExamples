/**
 * This class implements a heap sort.
 * Read through this after you've thoroughly understood the IntHeapArray class.
 */
public class IntHeapSorter {

    /**
     * Sort an array by building a heap inside of it, and then removing elements in sorted order.
     * @param array An array to sort.
     */
    public static void sort(int[] array) {
        // First make the array into a heap by bubbling up each element.
        for (int i=0;i<array.length;i++) {
            bubbleUp(i,array);
        }
        int heapSize = array.length;
        while (heapSize>0) {
            // Removing each value from the heap clears space for the sorted value at the end of the array.
            heapSize--;
            swap(0,heapSize,array);
            trickleDown(0,heapSize,array);
        }
    }

    /**
     * A convenience function for swapping values.
     * @param i First index.
     * @param j Second index.
     * @param array The array in which to swap values.
     */
    private static void swap(int i,int j,int array[]) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Bubble up an element at a given index from the bottom of the heap.
     * @param index Index of element to bubble up.
     * @param array A reference to the array.
     */
    private static void bubbleUp(int index,int[] array) {
        if (index==0) {
            return;
        }
        int parentIndex = (index-1)/2;
        if (array[index]>array[parentIndex]) {
            swap(index,parentIndex,array);
            bubbleUp(parentIndex,array);
        }
    }

    /**
     * Trickle down an element from the top of the array to an appropriate position.
     * @param index The index of the element to trickle down.
     * @param heapSize The number of elements in the array that are part of the heap.
     * @param array A reference to the array.
     */
    private static void trickleDown(int index,int heapSize,int[] array) {
        int leftChild = 2*index+1;
        int rightChild = 2*index+2;
        int biggestChild;
        if (rightChild<heapSize) {
            if (array[rightChild]>array[leftChild]) {
                biggestChild = rightChild;
            } else {
                biggestChild = leftChild;
            }
        } else if (leftChild<heapSize) {
            biggestChild = leftChild;
        } else {
            return;
        }
        if (array[biggestChild]>array[index]) {
            swap(biggestChild,index,array);
            trickleDown(biggestChild,heapSize,array);
        }
    }
}

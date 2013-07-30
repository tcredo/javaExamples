/**
 * A data structure organized as a tree of values such that each parent is greater than its children.
 * Here the heap is implemented with an array, using index arithmetic to keep track of the tree structure.
 */
public class IntHeapArray {

    /** The maximum number of values in the heap. */
    int capacity;

    /** An array to store values. */
    int[] values;

    /** The current number of values in the heap. */
    int currentSize;

    /**
     * Initialize the heap by creating an array to back it.
     * @param capacity The size of the array that backs up the heap. Inserting elements after reaching capacity will fail.
     */
    public IntHeapArray(int capacity) {
        this.capacity = capacity;
        values = new int[capacity];
        currentSize = 0;
    };

    /**
     * Add a new value to the heap, and then adjust to make sure the elements are in the right order.
     * @param value
     * @return A boolean indicated whether the insert was successful.
     */
    public boolean insert(int value) {
        if (currentSize>=capacity) {
            // If we've already filled up the array, the insert should fail.
            return false;
        }
        int index = currentSize;
        currentSize++;
        values[index] = value;
        // With the new value the end of the heap, bubbleUp moves it into the proper position.
        bubbleUp(index);
        return true;
    }

    /**
     * Remove a value from the top of the heap and readjust to restore the heap property.
     * @return The biggest value in the heap.
     * @throws IllegalStateException
     */
    public int pop() throws IllegalStateException {
        if (currentSize==0) {
            throw new IllegalStateException("The heap is empty");
        }
        int returnValue = values[0];
        // To rearrange the array, move the last value into the top position.
        values[0] = values[currentSize-1];
        currentSize--;
        // Then use trickleDown to get the elements back in order.
        trickleDown(0);
        return returnValue;
    };

    /**
     * A simple convenience function for swapping the values at two indices.
     * @param i The first index
     * @param j The second index
     */
    private void swap(int i,int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    /**
     * Recursively bubble up an element in the heap until it's in the right position.
     * @param index The index into values so start bubbling from.
     */
    private void bubbleUp(int index) {
        if (index==0) {
            // We've reached the top of the heap, so just return.
            return;
        }
        // Think carefully about this index math. Why does it work?
        int parentIndex = (index-1)/2;
        if (values[index]>values[parentIndex]) {
            // If the present value is bigger that its parent, swap with the parent and keep bubbling up.
            swap(index,parentIndex);
            bubbleUp(parentIndex);
        }
    }

    /**
     * Recursively move an element at the top of the heap into proper position by swapping with its children.
     * @param index The index of the value to move into place.
     */
    private void trickleDown(int index) {
        // Think carefully about this index arithmetic.
        int leftChild = 2*index+1;
        int rightChild = 2*index+2;
        int biggestChild;
        // First we look for the biggest child, being careful to check that it exists.
        if (rightChild<currentSize) {
            // If rightChild<currentSize, both child nodes are in the heap.
            if (values[rightChild]>values[leftChild]) {
                biggestChild = rightChild;
            } else {
                biggestChild = leftChild;
            }
        } else if (leftChild<currentSize) {
            // It might be possible to have only one child.
            biggestChild = leftChild;
        } else {
            // If there are no children, we've reached the bottom and can return.
            return;
        }
        if (values[biggestChild]>values[index]) {
            // If the value is smaller than a child, swap with the biggest child and keep trickling.
            swap(biggestChild,index);
            trickleDown(biggestChild);
        }
    }
}

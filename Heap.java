public abstract class Heap<T extends Comparable<T>> {

    public Comparable<T>[] data;
    public int size;

    public Heap() {
        this.data = (Comparable<T>[]) new Comparable[2];
        size = 0;
    }

    public Heap(T[] array) {
        // Step 1: Initialize the data array with the size of the input array
        this.data = (Comparable<T>[]) new Comparable[array.length];
        // Step 2: Copy the elements from the input array to the data array
        System.arraycopy(array, 0, this.data, 0, array.length);
        this.size = array.length;

        // Step 3: Apply Floyd's Algorithm to heapify the array
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // HELPER for HEAP constructor
    private void heapify(int index) {
        int largest = index;
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        // If left child is larger than root
        if (left < size && compare(data[left], data[largest])) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < size && compare(data[right], data[largest])) {
            largest = right;
        }

        // If largest is not root
        if (largest != index) {
            // Swap
            Comparable<T> swap = data[index];
            data[index] = data[largest];
            data[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(largest);
        }
    }

    protected abstract boolean compare(Comparable<T> child, Comparable<T> parent);

    public void push(T item) {
        // Step 1: Check if the heap is full
        if (size == data.length) {
            // Create a new array with double the size of the current one
            Comparable<T>[] newData = (Comparable<T>[]) new Comparable[data.length * 2];
            // Copy the contents of the old array into the new one
            System.arraycopy(data, 0, newData, 0, size);
            // Use the new array as the data array
            data = newData;
        }

        // Step 2: Add the new item to the end of the array
        data[size] = item;
        size++;

        // Step 3: Heapify the new item
        int current = size - 1; // Index of the new item
        while (current > 0 && compare(data[current], data[getParentIndex(current)])) {
            // Swap the new item with its parent
            Comparable<T> temp = data[current];
            data[current] = data[getParentIndex(current)];
            data[getParentIndex(current)] = temp;

            // Move up the tree
            current = getParentIndex(current);
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }


    public Comparable<T> pop() {
        // Step 1: Check if the heap is empty
        if (size == 0) {
            return null;
        }

        // Step 2: Remove the root of the heap
        Comparable<T> root = data[0]; // Store the root
        data[0] = data[size - 1]; // Replace the root with the last element
        size--; // Decrease the size

        // Step 3: Heapify the new root
        heapify(0);

        return root;
    }

    public Comparable<T> peek() {
        // Check if the heap is empty
        if (size == 0) {
            return null; // Return null if the heap is empty
        }

        // Return the root of the heap
        return data[0];
    }


    /*
     * 
     * Functions used for the toString
     * Do not change them but feel free to use them
     * 
     */

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(0, "", true, sb); // Start from the root
        return sb.toString();
    }

    private void buildString(int index, String prefix, boolean isTail, StringBuilder sb) {
        if (index < size) {
            String linePrefix = isTail ? "└── " : "┌── ";
            if (getRightChildIndex(index) < size) { // Check if there is a right child
                buildString(getRightChildIndex(index), prefix + (isTail ? "|   " : "    "), false, sb);
            }
            sb.append(prefix).append(linePrefix).append(data[index]).append("\n");
            if (getLeftChildIndex(index) < size) { // Check if there is a left child
                buildString(getLeftChildIndex(index), prefix + (isTail ? "    " : "│   "), true, sb);
            }
        }
    }

}

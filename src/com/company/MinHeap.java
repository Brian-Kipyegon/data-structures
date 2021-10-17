package com.company;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex *2) + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return (parentIndex *2) + 2;
    }
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftchildValue(int index) {
        return items[getLeftChildIndex(index)];
    }
    private int rightchildValue(int index) {
        return items[getRightChildIndex(index)];
    }
    private int parentValue(int index) {
        return items[getParentIndex(index)];
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    public void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureCapacity();
        items[size++ ] = item;
        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightchildValue(index) < leftchildValue(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] > items[smallerChildIndex]) {
                swap(index, smallerChildIndex);
            } else {
                break;
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size-1;
        while (hasParent(index) && items[index] < parentValue(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public String toString() {
        StringBuilder itemString = new StringBuilder("[");
        for ( int i = 0; i < size; i++) {
            if (i == size -1) {
                itemString.append(items[i]).append("]");
            } else {
                itemString.append(items[i]).append(", ");
            }
        }
        return itemString.toString();
    }
}

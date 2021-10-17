package com.company;

public class MaxHeap <E extends Comparable<E>>{
    private E[] heapq;
    private int size = 0;

    public MaxHeap(int capacity) {
        heapq = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(E data) {
        heapq[size++] = data;
        swim();
    }

    public E remove() {
        E data = heapq[0];
        heapq[0] = heapq[size - 1];
        heapq[--size] = null;
        sink();
        return data;
    }

    private void swim() {

    }

    private void sink() {

    }
}

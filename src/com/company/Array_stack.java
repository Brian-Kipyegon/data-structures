package com.company;

public class Array_stack <E> {
    private final E[] stack;
    private int N = 0;
    private int capacity = 10;

    public Array_stack(int capacity) {
        this.capacity = capacity;
        stack = (E[]) new Object[capacity];
    }
    public  Array_stack() {
        stack = (E[]) new Object[this.capacity];
    }

    public void  push(E element) {
        if (N >= capacity) throw  new IndexOutOfBoundsException();
        stack[N++] = element;
    }

    public E pop() {
        if (N <= 0) throw new IndexOutOfBoundsException();
        E item = stack[--N];
        stack[N] = null;
        return item;
    }

    public E peek() {
        return  stack[N-1];
    }

    public boolean isEmpty() { return  N == 0;}

}

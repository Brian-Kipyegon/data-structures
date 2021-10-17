package com.company;

public interface Stack <T> {
    void push(T data);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
    boolean contains(T data);
}

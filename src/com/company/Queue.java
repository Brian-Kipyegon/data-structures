package com.company;

public interface Queue <T> {
    void enqueue(T data);
    T dequeue();
    int size();
    boolean isEmpty();
    boolean contains(T data);
}

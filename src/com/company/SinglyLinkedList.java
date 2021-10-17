package com.company;

import java.util.AbstractList;

public class SinglyLinkedList <E> extends AbstractList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    /** Creates a new empty LinkedList */
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Appends an element to the end of the list
     * @param element The element to add
     */
    public boolean add(E element )
    {
        if (element == null) throw new NullPointerException("Null element");
        Node <E> newNode = new Node<E>(element);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail =  newNode;
        }
        size++;
        return true;
    }

    /** Gets the element at position index
     * @throws IndexOutOfBoundsException if the index is out of bounds. */
    public E get(int index)
    {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index " + index);
        int curr_index = 0;
        Node<E> currNode = head;
        while (currNode != null) {
            if (index == curr_index) {
                return currNode.data;
            }
            curr_index++;
            currNode = currNode.next;
        }
        return null;
    }

    /**
     * Adds an element to the list at the specified index
     * @param  index where the element should be added
     * @param element The element to add
     */
    @SuppressWarnings("null")
    public void add(int index, E element )
    {
        if (element == null) throw new NullPointerException("null elements not allowed.");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index.");
        if (index == size) { add(element); return; }
        int currIndex = 0;
        Node<E> newNode = new Node<E>(element);
        Node<E> currNode = head;
        Node<E> prevNode = null;
        Node<E> nextNode = null;
        while (currNode != null) {
            if (currIndex < index) {
                currNode = currNode.next;
            } else {
                break;
            }
            currIndex++;
        }
        prevNode = currNode.prev;
        nextNode = currNode;
        newNode.next = nextNode;
        newNode.prev = prevNode;
        if (prevNode != null) {
            prevNode.next = newNode;
        } else {
            head = newNode;
        }
        nextNode.prev = newNode;
        size++;
    }


    /** Returns the size of the list */
    public int size()
    {
        return this.size;
    }

    /** Removes a node at the specified index and return its data element.
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     *
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index " + index);
        int currIndex = 0;
        Node<E> currNode = head;
        Node<E> prevNode = null;
        Node<E> nextNode = null;
        while (currNode != null) {
            if (index == currIndex) {
                break;
            }
            currNode = currNode.next;
            currIndex++;
        }
        prevNode = currNode.prev;
        nextNode = currNode.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = currNode.next;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = currNode.prev;
        }
        currNode.next = null;
        currNode.prev = null;
        size--;
        return currNode.data;
    }

    /**
     * Sets an index position in the list to a new element
     * @param index The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element)
    {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (element == null) throw new NullPointerException("null values not allowed.");
        int currIndex = 0;
        Node<E> currNode = head;
        while (currNode != null) {
            if (currIndex == index) {
                break;
            }
            currNode = currNode.next;
            currIndex++;
        }
        E data = currNode.data;
        currNode.data = element;
        return data;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        Node<E> currNode = head;
        while (currNode != null) {
            if (currNode.next == null) {
                output.append(currNode.data);
            } else {
                output.append(currNode.data).append(" ->");
            }
            currNode = currNode.next;
        }
        return output.toString();
    }

}

class Node<E>
{
    Node<E> prev;
    Node<E> next;
    E data;

    public Node(E e)
    {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

    public String toString() {
        return "Node" + data;
    }

}



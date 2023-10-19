package agh.ii.prinjava.lab04.exc04_02.impl;

import java.util.NoSuchElementException;

/**
 * Doubly-linked list implementation.
 * @param <E> the type of elements held in this collection
 */
public class DLinkList<E> {
    private Node<E> first; // reference to the first node
    private Node<E> last; // reference to the last node
    private int size = 0; // number of elements in the list

    /**
     * Static nested class representing a node in the doubly-linked list.
     * @param <T> the type of element held within the node
     */
    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Adds an element at the beginning of the list.
     * @param e element to be added
     */
    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(e, null, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the end of the list.
     * @param e element to be added
     */
    public void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, l, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element from the list.
     * @return the element previously at the beginning of the list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<E> f = first;
        E element = f.elem;
        first = f.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return element;
    }

    /**
     * Removes and returns the last element from the list.
     * @return the element previously at the end of the list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        Node<E> l = last;
        E element = l.elem;
        last = l.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return element;
    }

    /**
     * Retrieves, but does not remove, the first element of this list.
     * @return the first element of this list
     * @throws NoSuchElementException if the list is empty
     */
    public E getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.elem;
    }

    /**
     * Retrieves, but does not remove, the last element of this list.
     * @return the last element of this list
     * @throws NoSuchElementException if the list is empty
     */
    public E getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.elem;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
}

package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import java.io.Serializable;

/**
 * A linked list-based implementation of the {@link QueueOfInts} interface.
 * This implementation uses a doubly linked list.
 */
public class LinkedListBasedImpl implements QueueOfInts, Serializable {

    /**
     * Adds an integer to the front of the queue.
     *
     * @param x The integer to be added to the queue.
     */
    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x);
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        }
        first = newNode;
        if (last == null) {
            last = newNode;
        }
        numOfElems++;
    }

    /**
     * Removes and returns the integer from the back of the queue.
     *
     * @return The integer at the back of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }

        int value = last.elem;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        numOfElems--;
        return value;
    }
    /**
     * Returns the number of elements currently in the queue.
     *
     * @return The number of elements in the queue.
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * Returns the integer at the back of the queue without removing it.
     *
     * @return The integer at the back of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return last.elem;
    }

    /**
     * Represents a node in the doubly linked list used by {@link LinkedListBasedImpl}.
     */
    private static class Node implements Serializable {
        int elem;
        Node next;
        Node prev;

        /**
         * Constructs a new node with the given element.
         *
         * @param elem The integer element of the node.
         */
        public Node(int elem) {
            this.elem = elem;
        }

        /**
         * Constructs a new node with the given element, next node, and previous node.
         *
         * @param elem The integer element of the node.
         * @param next Reference to the next node.
         * @param prev Reference to the previous node.
         */
        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;
    private int numOfElems = 0;
}

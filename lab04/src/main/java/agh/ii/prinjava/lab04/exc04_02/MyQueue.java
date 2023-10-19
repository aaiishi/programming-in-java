package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyQueueDLLBImpl;
import java.util.NoSuchElementException;

/**
 * Generic queue interface.
 * This interface represents a first-in-first-out (FIFO) queue of objects.
 *
 * @param <E> the type of elements held in this collection
 */
public interface MyQueue<E> {

    /**
     * Inserts the specified element into this queue.
     *
     * @param x the element to add
     */
    void enqueue(E x);

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E dequeue() throws NoSuchElementException; // Throws an exception if the queue is empty

    /**
     * Checks if the queue is empty.
     *
     * @return true if this queue contains no elements
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E peek() throws NoSuchElementException; // Throws an exception if the queue is empty

    /**
     * Creates a new instance of MyQueue.
     *
     * @param <T> the type of the element
     * @return a new instance of MyQueue
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}

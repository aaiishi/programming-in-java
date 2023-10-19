package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import java.util.NoSuchElementException;

/**
 * Queue implementation using a doubly-linked list.
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Inserts the specified element into the queue.
     * @param x the element to add
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    /**
     * Retrieves and removes the head of the queue.
     * @return the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        if (elems.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elems.removeFirst();
    }

    /**
     * Returns the number of elements in the queue.
     * @return the number of elements
     */
    @Override
    public int numOfElems() {
        return elems.size();
    }

    /**
     * Retrieves, but does not remove, the head of the queue.
     * @return the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E peek() {
        if (elems.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elems.getFirst();
    }
}

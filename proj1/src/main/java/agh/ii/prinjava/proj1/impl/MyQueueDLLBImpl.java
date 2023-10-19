package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

/**
 * Implementation of the {@code MyQueue} interface using a doubly linked list.
 *
 * @param <E> the type of elements held in this queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {

    /** The list of elements in the queue */
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Inserts the specified element into the queue.
     *
     * @param x the element to be added to the queue
     */
    @Override
    public void enqueue(E x) {
        elems.addLast(x);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the front element of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E dequeue() {
        return elems.removeFirst();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return elems.getSize(); // Assuming you have a getSize method in DLinkList
    }

    /**
     * Retrieves, but does not remove, the element at the front of the queue.
     *
     * @return the front element of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    @Override
    public E peek() {
        return elems.getFirstElem(); // Assuming you have a getFirstElem method in DLinkList
    }
}


package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyQueueDLLBImpl;

/**
 * Represents a generic queue data structure.
 *
 * @param <E> the type of elements held in this queue
 */
public interface MyQueue<E> {

    /**
     * Adds an element to the end of the queue.
     *
     * @param x the element to be added to the queue
     */
    void enqueue(E x);

    /**
     * Removes the element from the front of the queue and returns it.
     *
     * @return the front element of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E dequeue();

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the front element of the queue.
     *
     * @return the front element of the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E peek();

    /**
     * Factory method to create an instance of a queue.
     * <p>
     * Pros of having a factory method in the interface:
     * <ul>
     *     <li>Provides a consistent way to create instances of the queue.</li>
     *     <li>Allows for flexibility in choosing the implementation.</li>
     * </ul>
     * Cons:
     * <ul>
     *     <li>Ties the interface to a specific implementation, which can limit flexibility.</li>
     *     <li>Users of the interface might expect different behaviors from other implementations.</li>
     * </ul>
     *
     * @param <T> the type of elements held in the created queue
     * @return a new queue instance
     */
    static <T> MyQueue<T> create() {
        return new MyQueueDLLBImpl<>();
    }
}

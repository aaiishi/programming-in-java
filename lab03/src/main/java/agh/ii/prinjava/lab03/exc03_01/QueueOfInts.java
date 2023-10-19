package agh.ii.prinjava.lab03.exc03_01;

/**
 * Represents a queue of integers. A queue is a First-In-First-Out (FIFO) data structure.
 * The first element added is the first one to be removed (and so on).
 */
public interface QueueOfInts {

    /**
     * Adds an integer to the end of the queue.
     *
     * @param x The integer to be added to the queue.
     */
    void enqueue(int x);

    /**
     * Removes and returns the integer from the front of the queue.
     *
     * @return The integer at the front of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int dequeue();

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, otherwise {@code false}.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return The number of elements in the queue.
     */
    int numOfElems();

    /**
     * Returns the integer at the front of the queue without removing it.
     *
     * @return The integer at the front of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    int peek();
}

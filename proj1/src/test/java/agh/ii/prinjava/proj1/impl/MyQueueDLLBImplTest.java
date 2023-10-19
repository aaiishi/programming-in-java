package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class provides test cases for the implementation of {@code MyQueue<E>} using a doubly-linked list.
 * It tests the main operations of a queue such as enqueue, dequeue, peek, and numOfElems.
 */
class MyQueueDLLBImplTest {

    /** The instance of the queue that will be tested */
    private MyQueue<Integer> queueOfInts;

    /**
     * This method is executed before each test. It initializes the queue instance.
     */
    @BeforeEach
    void setUp() {
        queueOfInts = MyQueue.create();
    }

    /**
     * This method is executed after each test. It sets the queue instance to null.
     */
    @AfterEach
    void tearDown() {
        queueOfInts = null;
    }

    /**
     * Test for the enqueue operation.
     * It checks if the elements are correctly added to the back of the queue.
     */
    @Test
    void testEnqueue() {
        queueOfInts.enqueue(1);
        assertEquals(1, queueOfInts.peek());

        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.peek()); // The front of the queue should still be 1
    }

    /**
     * Test for the dequeue operation.
     * It checks if the elements are correctly removed from the front of the queue and
     * if exceptions are thrown when trying to dequeue from an empty queue.
     */
    @Test
    void testDequeue() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.enqueue(3);

        assertEquals(1, queueOfInts.dequeue());
        assertEquals(2, queueOfInts.peek());

        assertEquals(2, queueOfInts.dequeue());
        assertEquals(3, queueOfInts.peek());

        assertEquals(3, queueOfInts.dequeue());

        assertThrows(IllegalStateException.class, queueOfInts::dequeue);
    }

    /**
     * Test for the numOfElems operation.
     * It checks if the number of elements in the queue is correctly updated after enqueue and dequeue operations.
     */
    @Test
    void testNumOfElems() {
        assertEquals(0, queueOfInts.numOfElems());

        queueOfInts.enqueue(1);
        assertEquals(1, queueOfInts.numOfElems());

        queueOfInts.enqueue(2);
        assertEquals(2, queueOfInts.numOfElems());

        queueOfInts.dequeue();
        assertEquals(1, queueOfInts.numOfElems());
    }

    /**
     * Test for the peek operation.
     * It checks if the correct element (the front) is returned without being removed from the queue.
     * It also checks if exceptions are thrown when trying to peek from an empty queue.
     */
    @Test
    void testPeek() {
        assertThrows(IllegalStateException.class, queueOfInts::peek);

        queueOfInts.enqueue(1);
        assertEquals(1, queueOfInts.peek());

        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.peek()); // The front of the queue should still be 1

        queueOfInts.dequeue();
        assertEquals(2, queueOfInts.peek());
    }
}


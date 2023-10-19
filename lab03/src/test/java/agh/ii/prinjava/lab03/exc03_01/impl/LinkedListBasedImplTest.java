package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class LinkedListBasedImplTest {

    private final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
        // Before each test, we start with an empty queue.
        while (!queueOfInts.isEmpty()) {
            queueOfInts.dequeue();
        }
    }

    @AfterEach
    void tearDown() {
        // Cleanup after each test if needed. For now, it's empty.
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void enqueueIncreasesSize() {
        queueOfInts.enqueue(1);
        assertEquals(1, queueOfInts.numOfElems());
    }

    @Test
    void dequeueDecreasesSize() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        queueOfInts.dequeue();
        assertEquals(1, queueOfInts.numOfElems());
    }

    @Test
    void dequeueReturnsCorrectValue() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.dequeue());
    }

    @Test
    void peekReturnsFrontWithoutRemoval() {
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.peek());
        assertEquals(2, queueOfInts.numOfElems());
    }

    @Test
    void dequeueOnEmptyQueueThrowsException() {
        assertThrows(IllegalStateException.class, () -> queueOfInts.dequeue());
    }

    @Test
    void peekOnEmptyQueueThrowsException() {
        assertThrows(IllegalStateException.class, () -> queueOfInts.peek());
    }
}

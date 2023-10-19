package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {

    MyQueue<Integer> queueOfInts;

    @BeforeEach
    void setUp() {
        queueOfInts = MyQueue.create();
    }

    @AfterEach
    void tearDown() {
        queueOfInts = null;
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty());
    }

    @Test
    void enqueue_thenDequeue_elementsShouldMatch() {
        queueOfInts.enqueue(1);
        assertEquals(1, queueOfInts.dequeue());
    }

    @Test
    void whenEmptyQueue_dequeue_shouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> queueOfInts.dequeue());
    }

    @Test
    void whenEmptyQueue_peek_shouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> queueOfInts.peek());
    }
}

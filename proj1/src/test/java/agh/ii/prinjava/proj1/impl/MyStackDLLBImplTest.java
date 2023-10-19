package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@code MyStackDLLBImpl<E>}.
 * It tests the primary functionalities of the stack implemented using a doubly-linked list.
 */
class MyStackDLLBImplTest {

    /** The stack of integers to be tested */
    private MyStack<Integer> stackOfInts;

    /**
     * Setup method executed before each test.
     * Initializes a new stack for each test.
     */
    @BeforeEach
    void setUp() {
        stackOfInts = MyStack.create();
    }

    /**
     * Tear down method executed after each test.
     * Cleans up the resources used during the test.
     */
    @AfterEach
    void tearDown() {
        stackOfInts = null;
    }

    /**
     * Tests the push operation of the stack.
     * It checks whether the pushed elements are correctly placed on the top of the stack.
     */
    @Test
    void testPush() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.peek());

        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek());
    }

    /**
     * Tests the pop operation of the stack.
     * It verifies if the top elements are correctly removed and if popping an empty stack throws an exception.
     */
    @Test
    void testPop() {
        stackOfInts.push(1);
        stackOfInts.push(2);
        stackOfInts.push(3);

        assertEquals(3, stackOfInts.pop());
        assertEquals(2, stackOfInts.pop());
        assertEquals(1, stackOfInts.pop());

        assertThrows(IllegalStateException.class, stackOfInts::pop);
    }

    /**
     * Tests the numOfElems operation, which returns the number of elements in the stack.
     * It checks if the count of elements is correctly maintained during push and pop operations.
     */
    @Test
    void testNumOfElems() {
        assertEquals(0, stackOfInts.numOfElems());

        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems());

        stackOfInts.push(2);
        assertEquals(2, stackOfInts.numOfElems());

        stackOfInts.pop();
        assertEquals(1, stackOfInts.numOfElems());
    }

    /**
     * Tests the peek operation of the stack.
     * It verifies if the top element is correctly retrieved without removal
     * and if peeking an empty stack throws an exception.
     */
    @Test
    void testPeek() {
        assertThrows(IllegalStateException.class, stackOfInts::peek);

        stackOfInts.push(1);
        assertEquals(1, stackOfInts.peek());

        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek());

        stackOfInts.pop();
        assertEquals(1, stackOfInts.peek());
    }
}


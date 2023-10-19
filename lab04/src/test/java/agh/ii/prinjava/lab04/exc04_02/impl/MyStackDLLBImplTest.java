package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {

    MyStack<Integer> stackOfInts;

    @BeforeEach
    void setUp() {
        stackOfInts = MyStack.create();
    }

    @AfterEach
    void tearDown() {
        stackOfInts = null;
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void push_thenPop_elementsShouldMatch() {
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.pop());
    }

    @Test
    void whenEmptyStack_pop_shouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> stackOfInts.pop());
    }

    @Test
    void whenEmptyStack_peek_shouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> stackOfInts.peek());
    }
}

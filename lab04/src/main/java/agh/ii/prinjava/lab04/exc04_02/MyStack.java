package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;
import java.util.NoSuchElementException;

/**
 * Generic stack interface.
 * This interface represents a last-in-first-out (LIFO) stack of objects.
 *
 * @param <E> the type of elements held in this collection
 */
public interface MyStack<E> {

    /**
     * Retrieves and removes the top of this stack.
     *
     * @return the top of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    E pop() throws NoSuchElementException; // Throws an exception if the stack is empty

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param x the item to be pushed onto this stack
     */
    void push(E x);

    /**
     * Checks if the stack is empty.
     *
     * @return true if this stack contains no items
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the top of this stack.
     *
     * @return the top of this stack
     * @throws NoSuchElementException if this stack is empty
     */
    E peek() throws NoSuchElementException; // Throws an exception if the stack is empty

    /**
     * Creates a new instance of MyStack.
     *
     * @param <T> the type of the element
     * @return a new instance of MyStack
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}

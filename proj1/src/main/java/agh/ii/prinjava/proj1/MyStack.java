package agh.ii.prinjava.proj1;

import agh.ii.prinjava.proj1.impl.MyStackDLLBImpl;

/**
 * Represents a generic stack data structure.
 *
 * @param <E> the type of elements held in this stack
 */
public interface MyStack<E> {

    /**
     * Removes the element on the top of the stack and returns it.
     *
     * @return the top element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    E pop();

    /**
     * Adds an element to the top of the stack.
     *
     * @param x the element to be added to the stack
     */
    void push(E x);

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the top element of the stack.
     *
     * @return the top element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    E peek();

    /**
     * Factory method to create an instance of a stack.
     * <p>
     * Pros of having a factory method in the interface:
     * <ul>
     *     <li>Provides a consistent way to create instances of the stack.</li>
     *     <li>Allows for flexibility in choosing the implementation.</li>
     * </ul>
     * Cons:
     * <ul>
     *     <li>Ties the interface to a specific implementation, which can limit flexibility.</li>
     *     <li>Users of the interface might expect different behaviors from other implementations.</li>
     * </ul>
     *
     * @param <T> the type of elements held in the created stack
     * @return a new stack instance
     */
    static <T> MyStack<T> create() {
        return new MyStackDLLBImpl<T>();
    }
}

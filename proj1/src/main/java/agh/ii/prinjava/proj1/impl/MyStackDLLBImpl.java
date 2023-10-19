package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyStack;

/**
 * Implementation of the {@code MyStack<E>} interface using a doubly-linked list.
 *
 * @param <E> the type of elements held in this stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {

    /** The doubly-linked list used to store the stack elements */
    private DLinkList<E> elems = new DLinkList<>();

    /**
     * Removes the element on the top of the stack and returns it.
     *
     * @return the top element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() {
        return elems.removeLast();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param x the element to be added to the stack
     */
    @Override
    public void push(E x) {
        elems.addLast(x);
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int numOfElems() {
        return elems.getSize();
    }

    /**
     * Retrieves, but does not remove, the top element of the stack.
     *
     * @return the top element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() {
        return elems.getLastElem();
    }
}
